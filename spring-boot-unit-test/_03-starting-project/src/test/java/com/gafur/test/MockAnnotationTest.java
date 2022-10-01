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

    @Mock
    private AppDao appDao;

    @InjectMocks// inject dependencies annotated with @Mock or @Spy
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
}
