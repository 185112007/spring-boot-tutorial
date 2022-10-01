package com.gafur.component;

import com.gafur.component.dao.AppDao;
import com.gafur.component.models.CollegeStudent;
import com.gafur.component.service.AppService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class MvcTestingExampleApp {
    public static void main(String[] args) {
        SpringApplication.run(MvcTestingExampleApp.class);
    }

    @Bean(name = "applicationExample")
    AppService getAppService(){
        return new AppService();
    }

    @Bean(name = "appDao")
    AppDao getAppDao(){
        return new AppDao();
    }

    @Bean(name = "collegeStudent")
    @Scope(value = "prototype")
    CollegeStudent getCollegeStudent(){
        return new CollegeStudent();
    }
}
