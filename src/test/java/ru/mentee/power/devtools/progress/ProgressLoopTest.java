package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование ProgressTracker")
class ProgressLoopTest {

    @Test
    @DisplayName("Суммарный прогресс для нескольких mentee с разным прогрессом")
    void shouldCalculateTotalProgressWhenMultipleMentees() {
        ProgressTracker tracker = new ProgressTracker();
        // ВАЖНО: именно массив, не List
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
}