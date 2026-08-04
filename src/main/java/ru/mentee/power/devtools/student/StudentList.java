package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
    }

    public int size() {
        return students.size();
    }

    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    public List<Student> getStudentsByCity(String city) {
        if (city == null || city.isEmpty()) {
            return new ArrayList<>();
        }


        return students.stream()
                .filter(s -> s.getCity() != null && s.getCity().equalsIgnoreCase(city))
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }
}