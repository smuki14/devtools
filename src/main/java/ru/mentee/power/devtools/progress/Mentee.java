package ru.mentee.power.devtools;

public class Mentee {
    private final String name;
    private final String city;
    private final String goal;
    private final int completedLessons;
    private final int totalLessons;

    public Mentee(String name, String city, String goal,
                  int completedLessons, int totalLessons) {

        if (completedLessons < 0 || totalLessons <= 0) {
            throw new IllegalArgumentException(
                    "completedLessons must be >= 0 and totalLessons > 0"
            );
        }
        if (completedLessons > totalLessons) {
            throw new IllegalArgumentException(
                    "completedLessons cannot be greater than totalLessons"
            );
        }

        this.name = name;
        this.city = city;
        this.goal = goal;
        this.completedLessons = completedLessons;
        this.totalLessons = totalLessons;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getGoal() {
        return goal;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public int getTotalLessons() {
        return totalLessons;
    }
}