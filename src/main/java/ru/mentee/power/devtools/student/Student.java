
package ru.mentee.power.devtools.student;

public class Student {
    private final String name;
    private final String city;

    public Student(String name, String city) {
        this.name = name;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}