package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {

    @Test
    @DisplayName("Суммарный прогресс для нескольких mentee с разным прогрессом")
    void shouldCalculateTotalProgressWhenMultipleMentees() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 25 из 36 уроков")
                .contains("осталось 11 уроков");
    }

    @Test
    @DisplayName("Суммарный прогресс для нескольких mentee с разным прогрессом")
    void shouldCalculateTotalProgress_whenMultipleMentees() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        // Дополнительная проверка: состав массива
        assertThat(mentees).extracting(Mentee::name)
                .containsExactly("Иван", "Мария", "Пётр");

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 25 из 36 уроков")
                .contains("осталось 11 уроков");
    }

    @Test
    @DisplayName("Все mentee завершили курс — осталось 0")
    void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 12, 12),
                new Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 24 из 24 уроков")
                .contains("осталось 0 уроков");
    }

    @Test
    @DisplayName("Конструктор Mentee должен выбрасывать исключение, если completedLessons > totalLessons")
    void menteeConstructorRejectsCompletedGreaterThanTotal() {
        Assertions.assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 15, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    @DisplayName("Средний процент: все mentee ровно на 50%")
    void averageProgressPercent_whenAllFiftyPercent() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 6, 12),
                new Mentee("Мария", "СПб", "Fullstack", 6, 12)
        };

        double result = tracker.averageProgressPercent(mentees);

        assertThat(result).isEqualTo(50.0);
    }

    @Test
    @DisplayName("Средний процент: дробный результат (5/12, 8/12, 12/12)")
    void averageProgressPercent_whenFractions() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 5, 12),
                new Mentee("Мария", "СПб", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java", 12, 12)
        };

        double result = tracker.averageProgressPercent(mentees);

        // вычисляем вручную: (5/12 + 8/12 + 12/12) / 3 = (0.41666 + 0.66666 + 1.0) / 3 ≈ 0.69444 * 100?
        // Подождите, процент – это completed/total * 100.
        // (5*100/12 + 8*100/12 + 12*100/12) / 3 = (41.6667 + 66.6667 + 100) / 3 = 208.3334 / 3 ≈ 69.4444
        assertThat(result).isCloseTo(69.44, offset(0.01));
    }

    @Test
    @DisplayName("averageProgressPercent выбрасывает исключение при пустом массиве")
    void averageProgressPercent_throwsWhenEmptyArray() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] empty = {};

        Assertions.assertThatThrownBy(() -> tracker.averageProgressPercent(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пустой список mentee");
    }

    @Test
    @DisplayName("Средний процент всегда между 0 и 100 для непустого массива")
    void averageProgressPercent_betweenZeroAndHundred() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 3, 12),
                new Mentee("Мария", "СПб", "Fullstack", 12, 12)
        };

        double result = tracker.averageProgressPercent(mentees);

        assertThat(result)
                .isGreaterThan(0)
                .isLessThanOrEqualTo(100);
    }

    @Test
    @DisplayName("Конструктор Mentee должен выбрасывать исключение при отрицательном completedLessons")
    void menteeConstructorRejectsNegativeCompleted() {
        Assertions.assertThatThrownBy(() -> new Mentee("Мария", "СПб", "Fullstack", -3, 12))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    @DisplayName("Конструктор Mentee не должен выбрасывать исключение при корректных данных")
    void menteeConstructorAcceptsValidData() {
        Assertions.assertThatCode(() -> new Mentee("Пётр", "Казань", "Java", 5, 12))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Метод main должен запускаться без ошибок")
    void shouldRunMainWithoutErrors() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            ProgressTracker.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        assertThat(outContent.toString()).isNotEmpty();
    }
}