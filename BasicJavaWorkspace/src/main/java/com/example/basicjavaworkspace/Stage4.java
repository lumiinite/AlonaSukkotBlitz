package com.example.basicjavaworkspace;
import java.util.Scanner;
public class Stage4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("num 1:");
        int a = sc.nextInt();
        System.out.println("num 2:");
        int b = sc.nextInt();
        System.out.println("operator? + - * /");
        char op = sc.next().charAt(0);
        int res;
        if (op == '+') {
            res = add(a, b);
        } else if (op == '-') {
            res = subtract(a, b);
        } else if (op == '*') {
            res = multi(a, b);
        } else if (op == '/') {
            res = divide(a, b);
        } else {
            System.out.println("incorrect operator");
            return;
        }
        System.out.println(res);
    }
    public boolean prime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }




    public static int add( int x , int y) {
        return x+y;

    }

    public static int subtract(int a, int b) {
        return a-b;

    }

    public static int multi (int a, int b) {
        return a*b;

    }

    public static int divide(int a, int b) {
        return a/b;

    }
}


