package com.example.basicjavaworkspace;

public class PartTimeEmployee extends Employee{

    public double hourlyRate, hoursWorked;
    @Override
    public double calcPay(){
        return hourlyRate*hoursWorked;
    }
    @Override
    public String getDetails(){
        return "part time employee";
    }

    public FullTimeEmployee promote() {
        return new FullTimeEmployee(name);
    }



}
