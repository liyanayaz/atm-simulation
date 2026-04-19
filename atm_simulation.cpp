// Project: ATM Simulation - Advanced Version
// Description: A C++ ATM simulation with PIN authentication (3 attempts),
//              multiple account management using vectors, and the following features:
//              balance inquiry, withdrawal, deposit, account-to-account transfer,
//              and account creation. Card is blocked after 3 failed PIN attempts.

#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> accounts;
    string pin = "1234";
    bool pinVerified = false;

    string menu = "\n1- Balance Inquiry\n2- Withdrawal\n3- Deposit\n4- Account Transfer\n5- Add Account\n6- Exit\n";

    for (int i = 0; i < 3; i++) {
        string enteredPin;
        cout << "Enter your PIN: ";
        cin >> enteredPin;
        if (enteredPin == pin) {
            pinVerified = true;
            break;
        }
    }
    if (!pinVerified) {
        cout << "You have failed to enter the correct PIN 3 times. Your card has been blocked." << endl;
        return 0;
    }

    while (pinVerified) {
        cout << menu;
        string choice;
        cout << "Your choice: ";
        cin >> choice;

        if (choice == "6") {
            break;

        } else if (choice == "1") {  // balance inquiry
            if (accounts.empty()) {
                cout << "You have no accounts. Please add an account first." << endl;
            } else {
                for (int i = 0; i < accounts.size(); i++)
                    cout << "Account " << i+1 << ": " << accounts[i] << endl;
            }

        } else if (choice == "2") {  // withdrawal
            if (accounts.empty()) {
                cout << "You have no accounts. Please add an account first." << endl;
            } else {
                for (int i = 0; i < accounts.size(); i++)
                    cout << "Account " << i+1 << ": " << accounts[i] << endl;
                int accountSelect, amount;
                cout << "Select account to withdraw from: "; cin >> accountSelect;
                cout << "Enter amount to withdraw: "; cin >> amount;
                if (accounts[accountSelect - 1] < amount)
                    cout << "Insufficient balance..." << endl;
                else {
                    accounts[accountSelect - 1] -= amount;
                    cout << "Transaction completed." << endl;
                }
            }

        } else if (choice == "3") {  // deposit
            if (accounts.empty()) {
                cout << "You have no accounts. Please add an account first." << endl;
            } else {
                for (int i = 0; i < accounts.size(); i++)
                    cout << "Account " << i+1 << ": " << accounts[i] << endl;
                int accountSelect, amount;
                cout << "Select account to deposit into: "; cin >> accountSelect;
                cout << "Enter amount to deposit: "; cin >> amount;
                accounts[accountSelect - 1] += amount;
            }

        } else if (choice == "4") {  // account transfer
            if (accounts.size() < 2) {
                cout << "You do not have enough accounts to transfer." << endl;
            } else {
                for (int i = 0; i < accounts.size(); i++)
                    cout << "Account " << i+1 << ": " << accounts[i] << endl;
                int source, target, amount;
                cout << "Select source account: "; cin >> source;
                cout << "Select target account: "; cin >> target;
                cout << "Enter amount to transfer: "; cin >> amount;
                if (accounts[source - 1] < amount)
                    cout << "Insufficient balance..." << endl;
                else {
                    accounts[source - 1] -= amount;
                    accounts[target - 1] += amount;
                    cout << "Transfer completed successfully..." << endl;
                }
            }

        } else if (choice == "5") {  // add account
            int amount;
            cout << "Enter opening balance for new account: "; cin >> amount;
            accounts.push_back(amount);
            cout << "Account created successfully." << endl;
        }
    }
    return 0;
}
