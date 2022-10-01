package com.gafur.test;

import com.gafur.component.MvcTestingExampleApp;
import com.gafur.component.dao.AppDao;
import com.gafur.component.models.CollegeStudent;
import com.gafur.component.models.StudentGrades;
import com.gafur.component.service.AppService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApp.class)
class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    //@Mock
    @MockBean
    private AppDao appDao;

    //@InjectMocks// inject dependencies annotated with @Mock or @Spy
    @Autowired
    private AppService appService;

    @BeforeEach
    void beforeEach(){
        studentOne.setFirstName("Eric");
        studentOne.setLastName("Roby");
        studentOne.setEmailAddress("eric.roby@gmail.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @Test
    @DisplayName("When & Verify")
    void assertEqualsTestAddGrades(){
        when(appDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()))
                .thenReturn(100.00);

        assertEquals(100, appService.addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()));

        verify(appDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }

    @Test
    @DisplayName("Find Gpa")
    void assertEqualsTestFindGpa(){
        when(appDao.findGradePointAverage(studentGrades.getMathGradeResults()))
                .thenReturn(88.31);

        assertEquals(88.31, appService.findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));
    }

    @Test
    @DisplayName("Not Null")
    void testAssertNotNull(){
        when(appDao.checkNull(studentGrades.getMathGradeResults()))
                .thenReturn(true);

        assertNotNull(appService.checkNull(studentOne.getStudentGrades().getMathGradeResults()),
                "Object should not be null");
    }
}
