package com.example.basicjavaworkspace;

public class Dog extends Animal{
    @Override
    public void eat(){
        System.out.println("This dog is eating");
    }
    public Dog(String name) {
        super(name);
    }
    @Override
    public void speak(){
        System.out.println("woof");
    }
}
