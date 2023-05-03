package com.yeab.springdatajpa;

import com.yeab.springdatajpa.models.Course;
import com.yeab.springdatajpa.models.Teacher;
import com.yeab.springdatajpa.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;



    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("DotNet")
                .lastName("Lover")
                .build();
        Course course = Course.builder().title(".net")
                .credits(6)
                .teacher(teacher)
                .build();
        repository.save(course);
    }

}

