package com.gafur.component.models;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class StudentGrades {

    List<Double> mathGradeResults;
    /*
    CAN HAVE MULTIPLE DIFFERENT TYPES OF GRADES
    FOR 2.x WE WILL ONLY HAVE A MATH GRADE
     */

    public StudentGrades() {
        System.out.println("\n\n==>inside StudentGrade()");
    }

    public StudentGrades(List<Double> mathGradeResults) {
        this.mathGradeResults = mathGradeResults;
        /*
        Add another subject grades here in future lessons
         */
    }

    public double addGradeResultsForSingleClass(List<Double> grades){
        double result = 0;
        for(double grade : grades){
            result += grade;
        }
        return result;
    }

    public double findGradePointAverage(List<Double> grades){
        int lengthOfGrades = grades.size();
        double sum = addGradeResultsForSingleClass(grades);
        double result = sum/lengthOfGrades;

        // add a random function
        BigDecimal resultRound = BigDecimal.valueOf(result);
        resultRound = resultRound.setScale(2, RoundingMode.HALF_UP);
        return resultRound.doubleValue();
    }

    public Boolean isGradeGreater(double gradeOne, double gradeTwo){
        return gradeOne > gradeTwo;
    }

    public Object checkNull(Object obj){
        return obj;
    }

    public List<Double> getMathGradeResults(){
        return mathGradeResults;
    }

    public void setMathGradeResults(List<Double> mathGradeResults){
        this.mathGradeResults = mathGradeResults;
    }

    @Override
    public String toString() {
        return "StudentGrades{" +
                "mathGradeResults=" + mathGradeResults +
                '}';
    }
}
