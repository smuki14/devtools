package ru.mentee.power.devtools.examples;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentListTest {

    @Test
    void addStudentAddsOneStudentListSizeIncreases() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Ivan", "Moscow"));

        assertThat(list.getAll()).hasSize(1);
        assertEquals("Ivan", list.getAll().get(0).getName());
    }

    @Test
    void addStudentAddsMultipleStudentsAllAreStored() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Anna", "Rostov"));
        list.addStudent(new Student("Boris", "Rostov"));
        list.addStudent(new Student("Cedric", "Moscow"));

        List<Student> all = list.getAll();
        assertThat(all).hasSize(3);
        assertThat(all.get(0).getCity()).isEqualTo("Rostov");
        assertThat(all.get(2).getCity()).isEqualTo("Moscow");
    }

    @Test
    void getStudentsByCityReturnsOnlyStudentsFromThatCity() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Alice", "Rostov"));
        list.addStudent(new Student("Bob", "Rostov"));
        list.addStudent(new Student("Charlie", "Moscow"));

        List<Student> rostovStudents = list.getStudentsByCity("Rostov");

        assertThat(rostovStudents).hasSize(2);
        assertThat(rostovStudents.get(0).getName()).isEqualTo("Alice");
        assertThat(rostovStudents.get(1).getName()).isEqualTo("Bob");
    }

    @Test
    void getStudentsByCityCityNotFoundReturnsEmptyList() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Diana", "Moscow"));

        List<Student> unknownCity = list.getStudentsByCity("UnknownCity");

        assertThat(unknownCity).isEmpty();
    }
}