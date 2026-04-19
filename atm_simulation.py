# Project: ATM Simulation - Advanced Version
# Description: A Python ATM simulation with PIN authentication (3 attempts),
#              multiple account management using lists, and the following features:
#              balance inquiry, withdrawal, deposit, account-to-account transfer,
#              and account creation. Card is blocked after 3 failed PIN attempts.

accounts = []
pin = "1234"
pin_verified = False

menu = """
1- Balance Inquiry
2- Withdrawal
3- Deposit
4- Account Transfer
5- Add Account
6- Exit
"""

for i in range(3):
    entered_pin = input("Enter your PIN: ")
    if entered_pin == pin:
        pin_verified = True
        break
else:
    print("You have failed to enter the correct PIN 3 times. Your card has been blocked.")

while pin_verified:
    print(menu)
    choice = input("Your choice: ")

    if choice == "6":  # exit
        break

    elif choice == "1":  # balance inquiry
        if len(accounts) == 0:
            print("You have no accounts. Please add an account first.")
        else:
            for i in range(len(accounts)):
                print(f"Account {i+1}: {accounts[i]}")

    elif choice == "2":  # withdrawal
        if len(accounts) == 0:
            print("You have no accounts. Please add an account first.")
        else:
            for i in range(len(accounts)):
                print(f"Account {i+1}: {accounts[i]}")
            account_select = int(input("Select account to withdraw from: "))
            amount = int(input("Enter amount to withdraw: "))
            if accounts[account_select - 1] < amount:
                print("Insufficient balance...")
            else:
                accounts[account_select - 1] -= amount
                print("Transaction completed.")

    elif choice == "3":  # deposit
        if len(accounts) == 0:
            print("You have no accounts. Please add an account first.")
        else:
            for i in range(len(accounts)):
                print(f"Account {i+1}: {accounts[i]}")
            account_select = int(input("Select account to deposit into: "))
            amount = int(input("Enter amount to deposit: "))
            accounts[account_select - 1] += amount

    elif choice == "4":  # account transfer
        if len(accounts) < 2:
            print("You do not have enough accounts to transfer.")
        else:
            for i in range(len(accounts)):
                print(f"Account {i+1}: {accounts[i]}")
            source_account = int(input("Select source account: "))
            target_account = int(input("Select target account: "))
            amount = int(input("Enter amount to transfer: "))
            if accounts[source_account - 1] < amount:
                print("Insufficient balance...")
            else:
                accounts[source_account - 1] -= amount
                accounts[target_account - 1] += amount
                print("Transfer completed successfully...")

    elif choice == "5":  # add account
        amount = int(input("Enter opening balance for new account: "))
        accounts.append(amount)
        print("Account created successfully.")
