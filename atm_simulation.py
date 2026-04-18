# Project: ATM Simulation
# Description: A simple ATM simulation using Object-Oriented Programming.
#              Provides balance inquiry, deposit, withdrawal, and card return.
#              Uses a constructor to set initial balance, a while loop for
#              the menu, and input validation for insufficient funds.
# Course: Object-Oriented Programming

class ATM:
    def __init__(self):
        self.balance = 1000

    def check_balance(self):
        print(f"Current Balance: {self.balance} USD")

    def deposit(self):
        amount = int(input("Enter amount to deposit: "))
        self.balance += amount
        print(f"Updated Balance: {self.balance} USD")

    def withdraw(self):
        while True:
            amount = int(input("Enter amount to withdraw: "))
            if amount > self.balance:
                print("Insufficient balance. Please try again.")
            else:
                self.balance -= amount
                print(f"Updated Balance: {self.balance} USD")
                break

    def return_card(self):
        print("Your card is being returned...")


atm1 = ATM()
atm1.check_balance()

print("\nSelect an operation:")
print("1. Balance Inquiry")
print("2. Deposit")
print("3. Withdrawal")
print("4. Return Card")

transaction = 0
while transaction != 4:
    transaction = int(input("\nEnter your choice: "))
    if transaction == 1:
        atm1.check_balance()
    elif transaction == 2:
        atm1.deposit()
    elif transaction == 3:
        atm1.withdraw()
    elif transaction == 4:
        atm1.return_card()
    else:
        print("Invalid operation!")
