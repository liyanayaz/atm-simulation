// Project: ATM Simulation
// Description: A simple ATM simulation using Object-Oriented Programming.
//              Provides balance inquiry, deposit, withdrawal, and card return.
//              Uses a constructor to set initial balance, a while loop for
//              the menu, and input validation with goto for insufficient funds.
// Course: Object-Oriented Programming

#include <iostream>
using namespace std;

class ATM {
protected:
    int balance, transaction, amount;

public:
    ATM() {
        balance = 1000;
    }

    void checkBalance() {
        cout << "Current Balance: " << balance << " USD" << endl;
    }

    void deposit() {
        cout << "Enter amount to deposit: ";
        cin >> amount;
        balance += amount;
        cout << "Updated Balance: " << balance << " USD" << endl;
    }

    void withdraw() {
        cout << "Enter amount to withdraw: ";
        cin >> amount;

    retry:
        if (amount > balance) {
            cout << "Insufficient balance. Please try again: ";
            cin >> amount;
            goto retry;
        } else {
            balance -= amount;
            cout << "Updated Balance: " << balance << " USD" << endl;
        }
    }

    void returnCard() {
        cout << "Your card is being returned..." << endl;
    }
} atm1;

int main() {
    int transaction = 0;

    atm1.checkBalance();

    cout << "\nSelect an operation:" << endl;
    cout << "1. Balance Inquiry" << endl;
    cout << "2. Deposit" << endl;
    cout << "3. Withdrawal" << endl;
    cout << "4. Return Card" << endl;

    while (transaction != 4) {
        cout << "\nEnter your choice: ";
        cin >> transaction;

        switch (transaction) {
            case 1: atm1.checkBalance(); break;
            case 2: atm1.deposit();     break;
            case 3: atm1.withdraw();    break;
            case 4: atm1.returnCard();  break;
            default: cout << "Invalid operation!" << endl; break;
        }
    }

    return 0;
}
