package com.example.basicjavaworkspace;

import java.util.Arrays;
import java.util.Comparator;

public class Manager {
    public double fixedSalary,bonus;


    public double calcPay(){
        return fixedSalary+bonus;
    }


    public String getDetails(){
        return "mr bob work very hard yes";
    }


}
