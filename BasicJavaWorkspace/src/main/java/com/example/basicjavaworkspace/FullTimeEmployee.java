package com.example.basicjavaworkspace;

public class FullTimeEmployee extends Employee{


    int monthlySalary;

    @Override
    public double calcPay(){
        return monthlySalary;
    }

    @Override
    public String getDetails(){
        return "mr bob work very hard yes";
    }



}
