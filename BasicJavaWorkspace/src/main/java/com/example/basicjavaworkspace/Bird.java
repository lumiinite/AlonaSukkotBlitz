package com.example.basicjavaworkspace;

public class Bird extends Animal{
    @Override
    public void eat(){
        System.out.println("This DAAAAAAAAAAAAMNNNNNNN is eating");
    }
    public Bird(String name) {
        super(name);
    }
    @Override
    public void speak(){
        System.out.println("Chirp");
    }
}
