package ru.mentee.power;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenteeProgressTest {

    @Test
    void shouldFormatSummaryWhenProgressCreated() {
        MenteeProgress progress = new MenteeProgress("Сергей", 2, 10);

        String result = progress.summary();

        assertThat(result).isEqualTo("Sprint 2 → Сергей: planned 10 h");
    }

    @Test
    void shouldDetectReadinessWhenHoursAboveThreshold() {
        MenteeProgress progress = new MenteeProgress("Сергей", 2, 5);

        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadinessWhenHoursBelowThreshold() {
        MenteeProgress progress = new MenteeProgress("Сергей", 2, 2);

        assertThat(progress.readyForSprint()).isFalse();
    }
}