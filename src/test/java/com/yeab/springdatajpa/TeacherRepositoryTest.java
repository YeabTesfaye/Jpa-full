package com.yeab.springdatajpa;

import com.yeab.springdatajpa.models.Course;
import com.yeab.springdatajpa.models.Teacher;
import com.yeab.springdatajpa.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder().
                title("DBA")
                .credits(6).
                build();
        Course courseJAVA = Course.builder().
                title("JAVA").
                credits(6).build();
        Teacher teacher = Teacher.builder().
                firstName("Jack")
                .lastName("Jo").
                courses(List.of(courseDBA,courseJAVA)).build();
        teacherRepository.save(teacher);
        System.out.println("Teacher " + teacher);
    }
}
