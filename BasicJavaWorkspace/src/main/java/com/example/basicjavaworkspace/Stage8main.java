package com.example.basicjavaworkspace;

public class Stage8main {

    public static void main(String[] args) {
        FullTimeEmployee Ava = new FullTimeEmployee();
        PartTimeEmployee Max = new PartTimeEmployee();

        Payable[] list = { Ava, Max };
        for (int i = 0; i < 2 ; i++) {
            list[i].getDetails();
            list[i].calcPay();

        }

        }
}