package com.yeab.springdatajpa;


import com.yeab.springdatajpa.models.Guardian;
import com.yeab.springdatajpa.models.Student;
import com.yeab.springdatajpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .studentId(12L)
                .firstName("Doe")
                .lastName("Jap")
                .emailId("jpa@gamil.com")
//                .guardianName("Jk")
//                .guardianEmail("Jk@gmail.com")
//                .guardianPhone("34546456546")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Tes")
                .email("tes@gamil.com")
                .phone("23434345345")
                .build();
        Student student = Student.builder()
                .firstName("yeTes")
                .lastName("Tes")
                .emailId("yeTes@tes")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("yeab");
        System.out.println("Student List "  + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("ye");
        System.out.println("Student List "  + studentList);
    }

    @Test
    public void printAllStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Tes");
        System.out.println("Student List " + studentList );
    }

    @Test
    public void printAllStudentWhereTheLastNameIsNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("Student List " + studentList);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("yeTes", "Tes");
        System.out.println("Student " + student);
    }
    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByStudentEmailAddress("yeTes@tes");
        System.out.println("Student " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getFirstNameByStudentEmailAddress("yeTes@tes");
        System.out.println("Student FirstName " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getFirstNameByStudentEmailAddressNative("yeTes@tes");
        System.out.println("Student FirstName " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamed(){
        Student student  = studentRepository.getFirstNameByStudentEmailAddressNativeNamed("yeTes@tes");
        System.out.println("Student FirstName " + student);
    }
    @Test
    public  void updateFirstNameOfStudentByEmailId(){
         studentRepository.updateStudentNameByEmailId("Yeab", "yeTes@tes");
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList " + studentList );
    }
}
