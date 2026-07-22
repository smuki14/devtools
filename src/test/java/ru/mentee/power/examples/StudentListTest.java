package ru.mentee.power.devtools.examples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class StudentListTest {

    @Test
    void shouldAddStudentAndIncreaseSize() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Sergey", "Rostov"));
        assertEquals(1, list.size());
    }

    @Test
    void shouldReturnEmptyListWhenNoStudents() {
        StudentList list = new StudentList();
        assertTrue(list.getAll().isEmpty());
    }

    @Test
    void shouldFilterByCityCorrectly() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Sergey", "Rostov"));
        list.addStudent(new Student("Alexander", "SPb"));

        List<Student> rostov = list.getStudentsByCity("Rostov");
        assertEquals(1, rostov.size());
        assertEquals("Sergey", rostov.get(0).getName());
    }

    @Test
    void shouldReturnEmptyListForUnknownCity() {
        StudentList list = new StudentList();
        list.addStudent(new Student("Sergey", "Rostov"));

        assertTrue(list.getStudentsByCity("Tver").isEmpty());
    }
}