package com.javamsdt.actuator.repos;

import com.javamsdt.actuator.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("TEST")
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save_student_success() {
        Student student = new Student(1L, "student", "student@school.com");
        Student studentDb = studentRepository.save(student);

        assertEquals(student.getEmail(), studentDb.getEmail());
    }
}
