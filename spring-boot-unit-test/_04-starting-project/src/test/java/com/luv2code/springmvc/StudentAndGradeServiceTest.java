package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAndGradeServiceTest {

    @Autowired
    StudentAndGradeService studentService;

    @Autowired
    StudentDao studentDao;

    @Autowired
    JdbcTemplate jdbc;

    @BeforeEach
    void setupDatabase(){
        jdbc.execute("insert into student(firstname, lastname, email_address) " +
                "values ('Eric', 'Roby', 'eric.roby@gmail.com')");
    }

    @AfterEach
    void setupAfterTransaction(){
        jdbc.execute("delete from student");
    }

    @Test
    @Order(1)
    void createStudentService(){
        studentService.createStudent("Chad", "Darby", "chad.darby@gmail.com");

        Optional<CollegeStudent> student = studentDao.findByEmailAddress("chad.darby@gmail.com");

        student.ifPresent(collegeStudent -> assertEquals("chad.darby@gmail.com", collegeStudent.getEmailAddress(), "find by email"));

    }

    @Test
    @Order(2)
    void isStudentNullCheck(){

        assertTrue(studentService.checkIfStudentIsNull("eric.roby@gmail.com"));

        assertFalse(studentService.checkIfStudentIsNull("chad.darby@gmail.com"));
    }

    @Test
    @Order(3)
    void deleteStudentService(){
        Optional<CollegeStudent> deletedCollegeStudent = studentDao.findByEmailAddress("eric.roby@gmail.com");

        assertTrue(deletedCollegeStudent.isPresent(), "Return true");

        studentService.deleteStudent("eric.roby@gmail.com");

        deletedCollegeStudent = studentDao.findByEmailAddress("eric.roby@gmail.com");

        assertFalse(deletedCollegeStudent.isPresent(), "Return false");
    }

    @Test
    @Order(4)
    @Sql("/insert-data.sql")
    void getGradebookService(){
        Iterable<CollegeStudent> iterableCollegeStudents = studentService.getGradebook();

        List<CollegeStudent> collegeStudents = new ArrayList<>();

        for (CollegeStudent collegeStudent:iterableCollegeStudents){
            collegeStudents.add(collegeStudent);
        }

        assertEquals(5, collegeStudents.size());
    }
}
