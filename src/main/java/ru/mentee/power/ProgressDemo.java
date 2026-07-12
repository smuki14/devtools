
package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        MenteeProgress сергей = new MenteeProgress(
                "Сергей", // подставь своё имя
                2,              // номер спринта
                10               // часы из плана PLAN-2
        );

        var progress = сергей;

        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}