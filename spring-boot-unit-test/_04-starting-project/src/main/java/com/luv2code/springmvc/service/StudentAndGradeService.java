package com.luv2code.springmvc.service;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentAndGradeService {

    @Autowired
    StudentDao studentDao;

    public void createStudent(String firstname, String lastname, String emailAddress){
        CollegeStudent student = new CollegeStudent(firstname, lastname, emailAddress);
        studentDao.save(student);
    }

    public boolean checkIfStudentIsNull(String email) {
        Optional<CollegeStudent> student = studentDao.findByEmailAddress(email);
        return student.isPresent();
    }

    public void deleteStudent(String email) {
        if (checkIfStudentIsNull(email)){
            studentDao.deleteByEmailAddress(email);
        }
    }

    public Iterable<CollegeStudent> getGradebook() {

        return studentDao.findAll();
    }
}
