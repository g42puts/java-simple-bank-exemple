package org.example;

public class Bank {
    private User user;
    private double balance;

    public Bank(User user) {
        this.user = user;
        this.balance = 0.0;
    }

    public double getBalance() {
        System.out.println("Saldo atual: " + this.balance);
        return this.balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdrawn(double value) {
        if (this.balance >= value) {
            this.balance -= value;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void exit() {
        System.out.println("Obrigado por utilizar nossos serviços. Tenha um bom dia!");
    }
}
