package com.gafur.test;

import com.gafur.component.MvcTestingExampleApp;
import com.gafur.component.models.CollegeStudent;
import com.gafur.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MvcTestingExampleApp.class)
class ReflectionTestUtilsTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    void studentBeforeEach(){
        studentOne.setFirstName("Eric");
        studentOne.setLastName("Roby");
        studentOne.setEmailAddress("eric.roby@gmail.com");
        studentOne.setStudentGrades(studentGrades);

        ReflectionTestUtils.setField(studentOne, "id", 1);
        ReflectionTestUtils.setField(studentOne, "studentGrades",
                new StudentGrades(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.5, 91.75))));
    }

    @Test
    void getPrivateField(){
        assertEquals(1, ReflectionTestUtils.getField(studentOne, "id"));
    }

    @Test
    void invokePrivateMethod(){
        assertEquals("Eric 1", ReflectionTestUtils.invokeMethod(studentOne, "getFirstNameAndId"), "Fail private method not call");
    }
}
