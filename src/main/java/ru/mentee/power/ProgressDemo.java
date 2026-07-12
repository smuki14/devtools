
package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        System.out.println("Running in feature/DVT-4 context");

        System.out.println("Hello and welcome!");
        for (int step = 1; step <= 3; step++) {
            System.out.println("Step " + step);
        }
        System.out.println("HELLO DEVTOOLS");
    }
}