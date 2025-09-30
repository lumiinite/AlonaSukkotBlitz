package com.example.basicjavaworkspace;
import java.util.Scanner;
public class Stage1 {
    static Scanner sc = new Scanner(System.in);
    public  void tempCon(){
        double c = sc.nextDouble();
        double f = (9.0/5) * c + 32;
        String con = c + " °C is " + f + " °F";
        System.out.println(con);
    }
    public void stringForm(){
        String name = sc.next();
        String lname = sc.next();
        int age = sc.nextInt();
        System.out.println("Hello, my name is "+ name+" "+lname + " and I am "+age+" years old");
    }
}