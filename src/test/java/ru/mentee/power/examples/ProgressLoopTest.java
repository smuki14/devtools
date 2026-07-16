package ru.mentee.power.devtools.examples;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ProgressLoopTest {

    @Test
    void shouldCalculateTotalProgressCorrectly() {
        Mentee[] mentees = {
                new Mentee("A", "M", "B", 5, 12),
                new Mentee("B", "S", "B", 8, 12),
                new Mentee("C", "K", "B", 12, 12)
        };
        var result = ProgressTracker.calculateTotalProgress(mentees);

        assertThat(result.completed()).isEqualTo(25);
        assertThat(result.total()).isEqualTo(36);
        assertThat(result.remaining()).isEqualTo(11);
    }

    @Test
    void shouldReturnZeroForEmptyArray() {
        var result = ProgressTracker.calculateTotalProgress(new Mentee[0]);
        assertThat(result.completed()).isEqualTo(0);
        assertThat(result.total()).isEqualTo(0);
    }

    @Test
    void shouldThrowException_whenCompletedGreaterThanTotal() {
        assertThatThrownBy(() -> new Mentee("X", "Y", "Z", 15, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректные значения прогресса");
    }

    @Test
    void shouldNotThrowException_whenValidData() {
        assertThatCode(() -> new Mentee("V", "W", "X", 5, 12))
                .doesNotThrowAnyException();
    }
}