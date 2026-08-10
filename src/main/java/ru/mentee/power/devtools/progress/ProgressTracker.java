package ru.mentee.power.devtools.progress;

public class ProgressTracker {

    /**
     * Суммарный прогресс группы mentee.
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        int totalCompleted = 0;
        int totalTotal = 0;
        int index = 0;

        while (index < mentees.length) {
            Mentee mentee = mentees[index];
            // Для record используем методы без префикса get: completedLessons(), totalLessons()
            totalCompleted += mentee.completedLessons();
            totalTotal += mentee.totalLessons();
            index++;
        }

        int remaining = totalTotal - totalCompleted;
        return "Суммарно: пройдено " + totalCompleted + " из " + totalTotal + " уроков, " +
                "осталось " + remaining + " уроков";
    }

    public static void main(String[] args) {
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        System.out.println(new ProgressTracker().calculateTotalProgress(mentees));
    }

    public double averageProgressPercent(Mentee[] mentees) {
        if (mentees == null || mentees.length == 0) {
            throw new IllegalArgumentException("Пустой список mentee");
        }
        double totalPercent = 0.0;
        for (Mentee m : mentees) {
            // процент = completedLessons * 100.0 / totalLessons
            totalPercent += m.completedLessons() * 100.0 / m.totalLessons();
        }
        return totalPercent / mentees.length;
    }
}