package com.example.basicjavaworkspace;
import java.util.Scanner;
public class Stage2 {
    static Scanner sc = new Scanner(System.in);

    public void evenOdd() {
        int c = sc.nextInt();
        if (c % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }

    }

    public void gradesOhNo() {
        int c = sc.nextInt();
        char g=' '; //wont run any other way without this space thing
        if (c >= 90 && c <= 100) {
            g = 'A';
        } else if (c >= 80) {
            g = 'B';
        } else if (c >= 70) {
            g = 'C';
        } else if (c >= 60) {
            g = 'D';
        } else if (c >= 0) {
            g = 'F';
        } else {
            System.out.println("invalid grade");

        }
        System.out.println("grade:"+g);
    }


}