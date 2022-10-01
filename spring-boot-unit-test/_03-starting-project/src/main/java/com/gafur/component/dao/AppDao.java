package com.gafur.component.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AppDao {

    public double addGradeResultsForSingleClass(List<Double> grades){
        double result = 0;
        for (double grade: grades){
            result += grade;
        }
        return result;
    }

    public double findGradePointAverage(List<Double> grades){
        int lengthOfGrades = grades.size();
        double sum = addGradeResultsForSingleClass(grades);
        double result = sum/lengthOfGrades;

        // add a round function
        BigDecimal resultRound = BigDecimal.valueOf(result);
        resultRound = resultRound.setScale(2, RoundingMode.HALF_UP);
        return resultRound.doubleValue();
    }

    public Object checkNull(Object obj){
        return obj;
    }
}
