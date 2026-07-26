package ru.mentee.power.devtools;

import ru.mentee.power.devtools.progress.Mentee;

import java.util.List;

public class ProgressTracker {

    public String calculateTotalProgress(List<Mentee> mentees) {
        int totalCompleted = 0;
        int totalLessons = 0;

        for (Mentee m : mentees) {
            totalCompleted += m.getCompletedLessons();
            totalLessons += m.getTotalLessons();
        }

        int remaining = totalLessons - totalCompleted;
        return "Суммарно: пройдено " + totalCompleted + " из " + totalLessons + " уроков, осталось " + remaining + " уроков";
    }
}