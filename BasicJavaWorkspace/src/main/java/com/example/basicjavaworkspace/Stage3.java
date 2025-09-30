package com.example.basicjavaworkspace;

import java.util.Scanner;
import java.util.Random;
public class Stage3 {
    static Scanner sc = new Scanner(System.in);

    public void multiTable() {
        int n = sc.nextInt();
        int a = 1;
        while (a <= 10) {
            System.out.println(n + "*" + a + "=" + (n * a));
            a++;

        }
    }
    public void takeAGuess(){
        Random r = new Random(); //can prob also use math.random
        int c = r.nextInt(50) + 1;
        int a = sc.nextInt();
        while(a!=c){
            if(a<c){
                System.out.println("too low!");
            }
            else if(a>c){
                System.out.println("too high..");
            }
            System.out.println("take another guess");
            a = sc.nextInt();
        }
        System.out.println("You got it right, congrats.");
    }
}
