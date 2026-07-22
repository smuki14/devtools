package ru.mentee.power.devtools.student;

public class ProgressTracker {

    public static void main(String[] args) {
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend", 5, 12),
                new Mentee("Мария", "СПб", "Backend", 8, 12),
                new Mentee("Пётр", "Казань", "Backend", 12, 12)
        };

        ProgressResult result = calculateTotalProgress(mentees);
        System.out.printf("Суммарно: пройдено %d из %d уроков, осталось %d уроков%n",
                result.completed(), result.total(), result.remaining());
    }

    /**
     * Подсчёт суммарного прогресса через цикл while.
     */
    public static ProgressResult calculateTotalProgress(Mentee[] mentees) {
        // Валидация входных данных
        if (mentees == null || mentees.length == 0) {
            return new ProgressResult(0, 0);
        }

        // Инициализация
        int index = 0;
        int totalCompleted = 0;
        int totalTotal = 0;

        // Цикл while: явно показываем три элемента: инициализация, условие, изменение
        while (index < mentees.length) {
            Mentee m = mentees[index];
            totalCompleted += m.completedLessons();
            totalTotal += m.totalLessons();
            index++;
        }

        return new ProgressResult(totalCompleted, totalTotal);
    }

    // Вспомогательный record для результата
    public record ProgressResult(int completed, int total) {
        public int remaining() {
            return total - completed;
        }
    }
}