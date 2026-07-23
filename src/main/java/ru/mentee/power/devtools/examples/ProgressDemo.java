
package ru.mentee.power.devtools.examples;

public class ProgressDemo {
    public static void main(String[] args) {
        // Строка, которая явно показывает, что код выполняется в фича‑ветке
        System.out.println("Running in feature/DVT-3 context");

        System.out.println("Hello and welcome!");
        for (int step = 1; step <= 3; step++) {
            System.out.println("Step " + step);
        }
        System.out.println("HELLO DEVTOOLS");
    }
}