package com.gafur.test;

import com.gafur.component.MvcTestingExampleApp;
import com.gafur.component.models.CollegeStudent;
import com.gafur.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MvcTestingExampleApp.class)
public class AppExampleTest {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    void beforeEach() {
        count = count + 1;
        System.out.println("Testing: " + appInfo + " which is " + appDescription +
                " Version: " + appVersion + ". Execution of test method " + count);
        student.setFirstName("Eric");
        student.setLastName("Roby");
        student.setEmailAddress("eric.roby@gmail.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        student.setStudentGrades(studentGrades);
    }

    @Test
    @DisplayName("Add grade results for student grades")
    void addGradeResultsForStudentGrades() {
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
    }

    @Test
    @DisplayName("Add grade results for student grades not equals")
    void addGradeResultsForStudentGradesAssertNotEquals() {
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
    }

    @Test
    @DisplayName("Is grade greater")
    void isGradeGreaterStudentGrades() {
        assertTrue(studentGrades.isGradeGreater(90, 75), "failure - should be true");
    }

    @Test
    @DisplayName("Is grade greater false")
    void isGradeGreaterStudentGradesAssertFalse() {
        assertFalse(studentGrades.isGradeGreater(89, 92), "failure - should be false");
    }

    @Test
    @DisplayName("Check null for student grades")
    void checkNullForStudentGrades() {
        assertNotNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()), "object should be not be null");
    }

    @Test
    @DisplayName("Create student without grade init")
    void createStudentWithoutGradesInit() {
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);
        studentTwo.setFirstName("Chad");
        studentTwo.setLastName("Darby");
        studentTwo.setEmailAddress("chad.darby@gmail.com");
        assertNotNull(studentTwo.getFirstName());
        assertNotNull(studentTwo.getLastName());
        assertNotNull(studentTwo.getEmailAddress());
        assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
    }

    @Test
    @DisplayName("Verify students are prototypes")
    void verifyStudentsArePrototypes() {
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);

        assertNotSame(student, studentTwo);
    }

    @Test
    @DisplayName("Find Grade Point Average")
    void findGradePointAverage() {
        assertAll("Testing all assertEquals",
                () -> assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(
                        student.getStudentGrades().getMathGradeResults())),
                () -> assertEquals(88.31, studentGrades.findGradePointAverage(
                        student.getStudentGrades().getMathGradeResults()
                )));
    }
}
