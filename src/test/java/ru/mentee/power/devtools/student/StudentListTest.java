package ru.mentee.power.devtools.student;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void shouldAddStudentAndIncreaseSize() {
        Student student = new Student("Sergey", "Rostov");
        studentList.addStudent(student);

        assertEquals(1, studentList.size());
    }

    @Test
    void shouldReturnAllStudents() {
        Student student1 = new Student("Sergey", "Rostov");
        Student student2 = new Student("Alexander", "SPb");
        studentList.addStudent(student1);
        studentList.addStudent(student2);

        List<Student> all = studentList.getAll();

        assertEquals(2, all.size());
        assertThat(all).containsExactly(student1, student2);
    }

    @Test
    void shouldReturnEmptyListWhenNoStudents() {
        assertTrue(studentList.getAll().isEmpty());
    }

    @Test
    void shouldFilterByCityCorrectly() {
        Student student1 = new Student("Sergey", "Rostov");
        Student student2 = new Student("Alexander", "SPb");
        studentList.addStudent(student1);
        studentList.addStudent(student2);

        List<Student> rostov = studentList.getStudentsByCity("Rostov");

        assertEquals(1, rostov.size());
        assertEquals("Sergey", rostov.get(0).getName());
        assertEquals("Rostov", rostov.get(0).getCity()); // дополнительная проверка
    }

    @Test
    void shouldReturnEmptyListForUnknownCity() {
        studentList.addStudent(new Student("Sergey", "Rostov"));

        List<Student> result = studentList.getStudentsByCity("Tver");

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenCityIsNull() {
        studentList.addStudent(new Student("Sergey", "Rostov"));
        studentList.addStudent(new Student("Alexander", "SPb"));

        List<Student> result = studentList.getStudentsByCity(null);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenCityIsEmpty() {
        studentList.addStudent(new Student("Sergey", "Rostov"));

        List<Student> result = studentList.getStudentsByCity("");

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnMultipleStudentsFromSameCity() {
        studentList.addStudent(new Student("Sergey", "Rostov"));
        studentList.addStudent(new Student("Ivan", "Rostov"));
        studentList.addStudent(new Student("Alexander", "SPb"));

        List<Student> rostov = studentList.getStudentsByCity("Rostov");

        assertEquals(2, rostov.size());
        // Используем containsExactlyInAnyOrder, чтобы порядок не имел значения
        assertThat(rostov).extracting(Student::getName)
                .containsExactlyInAnyOrder("Sergey", "Ivan");

        // Проверяем, что все студенты из Ростова
        assertThat(rostov).allMatch(s -> "Rostov".equals(s.getCity()));
    }

    @Test
    void shouldNotModifyOriginalListWhenGetAll() {
        Student student = new Student("Sergey", "Rostov");
        studentList.addStudent(student);

        List<Student> all = studentList.getAll();
        all.clear(); // Изменяем полученный список

        assertEquals(1, studentList.size()); // Оригинал не изменился
    }

    @Test
    void shouldReturnSizeZeroForEmptyList() {
        assertEquals(0, studentList.size());
    }

    @Test
    void shouldHandleMultipleAdditions() {
        studentList.addStudent(new Student("Student1", "City1"));
        studentList.addStudent(new Student("Student2", "City2"));
        studentList.addStudent(new Student("Student3", "City3"));

        assertEquals(3, studentList.size());
        assertEquals(3, studentList.getAll().size());
    }

    @Test
    void shouldFilterByCityCaseInsensitive() {
        studentList.addStudent(new Student("Sergey", "Rostov"));
        studentList.addStudent(new Student("Ivan", "rostov")); // с маленькой буквы

        // Если ваш метод использует equalsIgnoreCase, оба должны найтись
        List<Student> result = studentList.getStudentsByCity("Rostov");

        // Если метод использует equals (чувствительный к регистру),
        // то найдётся только один студент
        // Этот тест покажет, какое поведение у вашего метода
        System.out.println("Found students: " + result.size());
    }
}