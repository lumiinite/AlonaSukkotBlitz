package com.example.basicjavaworkspace;

public class Stage7main {
    public static void main(String[] args) {
//        Shape[] shapes = new Shape[3];   shape calc
//        shapes[0] = new Circle(3.0);
//        shapes[1] = new Triangle(2.0,5.4);
//        shapes[2] = new Rectangle(2.0,3.2);
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Shape:" + shapes[i]+", Area:"+ shapes[i].area());
//        }

        Animal[] animals = new Animal[3];
        animals[0] = new Bird("DAAAAAAAMNNNNNN");
        animals[1] = new Dog("yes");
        animals[2] = new Cat("Nyxie");
        for (int i = 0; i < 3; i++) {
           animals[i].speak();
            System.out.print(animals[i].name + " says ");
            animals[i].speak();
            animals[i].eat();
        }
    }
}
