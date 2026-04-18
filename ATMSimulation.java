// Project: ATM Simulation
// Description: A simple ATM simulation using Object-Oriented Programming.
//              Provides balance inquiry, deposit, withdrawal, and card return.
//              Uses a constructor to set initial balance, a while loop for
//              the menu, and input validation for insufficient funds.
// Course: Object-Oriented Programming

import java.util.Scanner;

class ATM {
    protected int balance;
    protected int transaction;
    protected int amount;
    static Scanner scanner = new Scanner(System.in);

    ATM() {
        balance = 1000;
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance + " USD");
    }

    void deposit() {
        System.out.print("Enter amount to deposit: ");
        amount = scanner.nextInt();
        balance += amount;
        System.out.println("Updated Balance: " + balance + " USD");
    }

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        amount = scanner.nextInt();
        while (amount > balance) {
            System.out.print("Insufficient balance. Please try again: ");
            amount = scanner.nextInt();
        }
        balance -= amount;
        System.out.println("Updated Balance: " + balance + " USD");
    }

    void returnCard() {
        System.out.println("Your card is being returned...");
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        ATM atm1 = new ATM();
        Scanner scanner = new Scanner(System.in);
        int transaction = 0;

        atm1.checkBalance();

        System.out.println("\nSelect an operation:");
        System.out.println("1. Balance Inquiry");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Return Card");

        while (transaction != 4) {
            System.out.print("\nEnter your choice: ");
            transaction = scanner.nextInt();

            switch (transaction) {
                case 1: atm1.checkBalance(); break;
                case 2: atm1.deposit();      break;
                case 3: atm1.withdraw();     break;
                case 4: atm1.returnCard();   break;
                default: System.out.println("Invalid operation!"); break;
            }
        }
    }
}
