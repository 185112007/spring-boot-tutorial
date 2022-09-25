package com.gafur.junitdemo;

public class DemoUtils {

    private String academy = "Luv2Code Academy";
    private String academyDuplicate = academy;

    public String getAcademy() {
        return academy;
    }

    public String getAcademyDuplicate() {
        return academyDuplicate;
    }

    public int add(int a, int b){
        return a + b;
    }

    public Object checkNull(Object obj){
        if (obj != null){
            return obj;
        }
        return null;
    }

    public Boolean isGreater(int n1, int n2){
        return n1 > n2;
    }
}
