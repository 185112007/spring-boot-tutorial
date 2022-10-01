package com.gafur.component.service;

import com.gafur.component.dao.AppDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppService {

    @Autowired
    private AppDao appDao;

    public double addGradeResultsForSingleClass(List<Double> numbers){
        return appDao.addGradeResultsForSingleClass(numbers);
    }

    public double findGradePointAverage(List<Double> grades){
        return appDao.findGradePointAverage(grades);
    }

    public Object checkNull(Object obj){
        return appDao.checkNull(obj);
    }
}
