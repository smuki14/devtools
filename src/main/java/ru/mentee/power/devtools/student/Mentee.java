
package ru.mentee.power.devtools.student;

public record Mentee(String name, String city, String goal, int completedLessons, int totalLessons) {
    public Mentee {
        if (completedLessons < 0 || totalLessons <= 0) {
            throw new IllegalArgumentException("Некорректные значения прогресса");
        }
        if (completedLessons > totalLessons) {
            throw new IllegalArgumentException("Некорректные значения прогресса: completed не может быть больше total");
        }
    }
}