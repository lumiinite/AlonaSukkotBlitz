package com.example.basicjavaworkspace;

public class Circle extends Shape{
    public double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double area(){
        return Math.PI*radius*radius ;
    }

    @Override
    public String toString(){
        return "Circle";
    }
}
