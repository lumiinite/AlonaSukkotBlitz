package com.example.basicjavaworkspace;

public class Stage6main {
    public static void main(String[] args) {
    BankAccount alona = new BankAccount("Alona", 670000);
        System.out.println(alona.getBalance());
        alona.deposit(2);
        System.out.println(alona.getBalance());

        // ------------------------------------

        Student Ava = new Student("Ava", new int[]{97, 32, 57, 100, 56, 76, 89, 100, 32, 80, 83, 78});
        Student Allan = new Student("Ava", new int[]{100, 72, 65, 100, 98, 76, 67, 100, 32, 80, 93, 78});
        Student yes = new Student("Ava", new int[]{67, 67, 67, 67 ,67, 67,67, 67, 67, 67, 67, 78});
        System.out.println(Ava.getAvg());
        System.out.println(Allan.getAvg());
        System.out.println(yes.getAvg());
    }


}
