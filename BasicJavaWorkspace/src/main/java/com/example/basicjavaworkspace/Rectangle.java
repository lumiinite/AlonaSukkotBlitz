package com.example.basicjavaworkspace;

public class Rectangle extends Shape {
    public double height;
    public double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double area(){
        return height*width ;
    }

    @Override
    public String toString (){
        return "Rectangle";
    }
}
