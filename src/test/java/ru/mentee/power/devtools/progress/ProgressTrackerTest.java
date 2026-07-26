package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

import ru.mentee.power.devtools.progress.Mentee;
import ru.mentee.power.devtools.progress.ProgressTracker;

class ProgressTrackerTest {

   
    @Test
    void calculateTotalProgress_25_of_36() {
        List<Mentee> mentees = List.of(
                new Mentee("Alice", "Moscow", "Backend", 25, 36)
        );
        ProgressTracker tracker = new ProgressTracker();
        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result).isEqualTo(
                "Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков"
        );
    }

    // Кейс: все завершили (24 из 24)
    @Test
    void calculateTotalProgress_all_completed_24_of_24() {
        List<Mentee> mentees = List.of(
                new Mentee("Bob", "SPb", "QA", 24, 24)
        );
        ProgressTracker tracker = new ProgressTracker();
        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result).isEqualTo(
                "Суммарно: пройдено 24 из 24 уроков, осталось 0 уроков"
        );
    }

    // Кейс: пустой список
    @Test
    void calculateTotalProgress_emptyList_returnsZero() {
        List<Mentee> mentees = List.of();
        ProgressTracker tracker = new ProgressTracker();
        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result).isEqualTo(
                "Суммарно: пройдено 0 из 0 уроков, осталось 0 уроков"
        );
    }

    // Кейс: несколько студентов
    @Test
    void calculateTotalProgress_multipleMentees() {
        List<Mentee> mentees = List.of(
                new Mentee("Carol", "Kazan", "Data", 10, 20),
                new Mentee("Dave", "Moscow", "DevOps", 5, 15)
        );
        ProgressTracker tracker = new ProgressTracker();
        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result).isEqualTo(
                "Суммарно: пройдено 15 из 35 уроков, осталось 20 уроков"
        );
    }

    // Кейс: проверка валидации в Mentee (некорректные данные)
    @Test
    void menteeConstructor_throws_for_invalid_data() {
        assertThatThrownBy(() ->
                new Mentee("Eve", "Rostov", "ML", -1, 10)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                new Mentee("Frank", "Ufa", "Frontend", 10, 5)  // completed > total
        ).isInstanceOf(IllegalArgumentException.class);
    }
}