// Project: ATM Simulation - Advanced Version
// Description: A Java ATM simulation with PIN authentication (3 attempts),
//              multiple account management using ArrayList, and the following features:
//              balance inquiry, withdrawal, deposit, account-to-account transfer,
//              and account creation. Card is blocked after 3 failed PIN attempts.

import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args) {
        ArrayList<Integer> accounts = new ArrayList<>();
        String pin = "1234";
        boolean pinVerified = false;
        Scanner scanner = new Scanner(System.in);

        String menu = "\n1- Balance Inquiry\n2- Withdrawal\n3- Deposit\n4- Account Transfer\n5- Add Account\n6- Exit\n";

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.next();
            if (enteredPin.equals(pin)) {
                pinVerified = true;
                break;
            }
        }
        if (!pinVerified) {
            System.out.println("You have failed to enter the correct PIN 3 times. Your card has been blocked.");
            return;
        }

        while (pinVerified) {
            System.out.println(menu);
            System.out.print("Your choice: ");
            String choice = scanner.next();

            if (choice.equals("6")) {
                break;

            } else if (choice.equals("1")) {  // balance inquiry
                if (accounts.isEmpty()) {
                    System.out.println("You have no accounts. Please add an account first.");
                } else {
                    for (int i = 0; i < accounts.size(); i++)
                        System.out.println("Account " + (i+1) + ": " + accounts.get(i));
                }

            } else if (choice.equals("2")) {  // withdrawal
                if (accounts.isEmpty()) {
                    System.out.println("You have no accounts. Please add an account first.");
                } else {
                    for (int i = 0; i < accounts.size(); i++)
                        System.out.println("Account " + (i+1) + ": " + accounts.get(i));
                    System.out.print("Select account to withdraw from: ");
                    int accountSelect = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    int amount = scanner.nextInt();
                    if (accounts.get(accountSelect - 1) < amount)
                        System.out.println("Insufficient balance...");
                    else {
                        accounts.set(accountSelect - 1, accounts.get(accountSelect - 1) - amount);
                        System.out.println("Transaction completed.");
                    }
                }

            } else if (choice.equals("3")) {  // deposit
                if (accounts.isEmpty()) {
                    System.out.println("You have no accounts. Please add an account first.");
                } else {
                    for (int i = 0; i < accounts.size(); i++)
                        System.out.println("Account " + (i+1) + ": " + accounts.get(i));
                    System.out.print("Select account to deposit into: ");
                    int accountSelect = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    accounts.set(accountSelect - 1, accounts.get(accountSelect - 1) + amount);
                }

            } else if (choice.equals("4")) {  // account transfer
                if (accounts.size() < 2) {
                    System.out.println("You do not have enough accounts to transfer.");
                } else {
                    for (int i = 0; i < accounts.size(); i++)
                        System.out.println("Account " + (i+1) + ": " + accounts.get(i));
                    System.out.print("Select source account: ");
                    int source = scanner.nextInt();
                    System.out.print("Select target account: ");
                    int target = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    int amount = scanner.nextInt();
                    if (accounts.get(source - 1) < amount)
                        System.out.println("Insufficient balance...");
                    else {
                        accounts.set(source - 1, accounts.get(source - 1) - amount);
                        accounts.set(target - 1, accounts.get(target - 1) + amount);
                        System.out.println("Transfer completed successfully...");
                    }
                }

            } else if (choice.equals("5")) {  // add account
                System.out.print("Enter opening balance for new account: ");
                int amount = scanner.nextInt();
                accounts.add(amount);
                System.out.println("Account created successfully.");
            }
        }
    }
}
