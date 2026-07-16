package ru.mentee.power;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenteeProgressTest {
    @Test
    void shouldFormatSummary_whenProgressCreated() {
        MenteeProgress progress = new MenteeProgress("Сергей", 2, 10);

        String result = progress.summary();

        assertThat(result).isEqualTo("Sprint 2 → Сергей: planned 10 h");
    }

    @Test
    void shouldDetectReadiness_whenHoursAboveThreshold() {
        MenteeProgress progress = new MenteeProgress("Сергей", 2, 5);

        assertThat(progress.readyForSprint()).isTrue();
    }

    @Test
    void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
        MenteeProgress progress = new MenteeProgress("Сергей", 2, 2);

        assertThat(progress.readyForSprint()).isFalse();
    }
}
