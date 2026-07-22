package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class StudentListTest {

    @Test
    void addStudentAddsOneStudentListSizeIncreases() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Ivan", "Moscow"));

        assertThat(list.getAll()).hasSize(1);
        assertEquals("Ivan", list.getAll().get(0).getName());
    }

    @Test
    void addStudentAddsStudentToList() {
        StudentList list = new StudentList();

        Student newStudent = new Student("Boris", "Kazan");
        list.addStudent(newStudent);

        assertThat(list.getAll()).containsExactly(newStudent);      // если getAll есть
        // или, если getAll нет, можно проверить через getStudentsByCity:
        // assertThat(list.getStudentsByCity("Kazan")).containsExactly(newStudent);
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
    void getStudentsByCityWithNullOrEmptyCityReturnsEmptyList() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Ivan", "Moscow"));
        list.addStudent(new Student("Anna", "Rostov"));

        // Проверяем null
        assertThat(list.getStudentsByCity(null)).isEmpty();

        // Проверяем пустую строку
        assertThat(list.getStudentsByCity("")).isEmpty();
    }
}