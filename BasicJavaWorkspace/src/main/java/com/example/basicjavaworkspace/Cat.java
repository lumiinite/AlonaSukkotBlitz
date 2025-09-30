package com.example.basicjavaworkspace;

public class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat(){
        System.out.println("This cat is eating");
    }

    @Override
    public void speak(){
        System.out.println("maow :3");
    }
}
