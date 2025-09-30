package com.example.basicjavaworkspace;

public class Student {
    String name;
    int[] grades = new int[12];

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public int getAvg(){
        int c = 0;
        for (int i = 1; i <= 12; i++) {
            c+=grades[i];
        }
        return c/12;
    }

}
