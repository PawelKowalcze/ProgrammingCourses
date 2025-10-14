# Python Banking Program

def show_balance(balance):
    print(f"Your balance is: ${balance:.2f}")

def deposit(balance, amount):
    print(f"Depositing: ${amount:.2f}")
    return balance + amount

def withdraw(balance, amount):
    if amount > balance:
        print("Insufficient funds")
        return balance
    else:
        print(f"Withdrawing: ${amount:.2f}")
        return balance - amount

def main():
    balance = 0
    is_running = True
    print("Python Banking Program")
    name = input("Enter your name: ")
    print(f"Hello {name}")
    while is_running:
        print("1. Show Balance")
        print("2. Deposit")
        print("3. Withdraw")
        print("4. Quit")
        option = int(input("Enter option: "))
        match option:
            case 1:
                show_balance(balance)
            case 2:
                amount = float(input("Enter amount to deposit: "))
                balance = deposit(balance,amount)
            case 3:
                amount = float(input("Enter amount to withdraw: "))
                balance = withdraw(balance,amount)
            case 4:
                is_running = False
            case _:
                print("Invalid option")

if __name__ == '__main__':
    main()