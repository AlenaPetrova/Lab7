package com.example.examples.viewmodel;

public class FragmentsProcessor {
    public static Double getLength(Double x1,Double x2,Double y1,Double y2){
       return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public static Integer getPlus(Integer x1,Integer x2){
        return x1+x2;
    }
    public static Integer getMult(Integer x1,Integer x2){
        return x1*x2;
    }
    public static Integer getMinus(Integer x1,Integer x2){
        return x1-x2;
    }
}
