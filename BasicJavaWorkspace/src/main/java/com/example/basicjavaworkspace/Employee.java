package com.example.basicjavaworkspace;

import java.util.Comparator;

public abstract class Employee implements Payable {

    public Employee(){}
    public Employee(String name) {
        this.name = name;
    }

    public enum EmployeeType{FULL_TIME, PART_TIME}
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getDetails();




}
