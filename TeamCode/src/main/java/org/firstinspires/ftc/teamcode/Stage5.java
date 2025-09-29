package org.firstinspires.ftc.teamcode;

import java.util.Scanner;

public class Stage5 {
    static Scanner sc = new Scanner(System.in);

    public void arrays() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int c = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println(a[i]);
            c++;
        }
        System.out.println(c);
    }

    public void wordSearch() {
        String[] yes = {"Singapore", "Vienna", "Munich", "Baghdad"};
        System.out.println("search for a word here");
        String a = sc.nextLine();
        boolean found = false;
        for (String b : yes) {
            if (a.equalsIgnoreCase(b)) { // case-insensitive check
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("word was found");
        } else {
            System.out.println("not found..");
        }
    }
}
