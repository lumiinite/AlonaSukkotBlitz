package com.example.basicjavaworkspace;

public class BankAccount {
    public String ownerName;
    public double balance;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
