package com.yeab.springdatajpa;

import com.yeab.springdatajpa.models.Course;
import com.yeab.springdatajpa.models.CourseMaterial;
import com.yeab.springdatajpa.repository.CourseMaterialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA").credits(4).build();
        CourseMaterial courseMaterial = CourseMaterial.
                builder().url("www.google.com").course(course).build();
        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterialList = repository.findAll();
        System.out.println("Course Material " + courseMaterialList);
    }


}
