package com.example.basicjavaworkspace;

public class Animal {
    public String name;
    public void speak(){
        System.out.println("...");
    }

    public void eat(){
        System.out.println("This animal is eating");
    }

    public Animal(String name) {
        this.name = name;
    }
}
