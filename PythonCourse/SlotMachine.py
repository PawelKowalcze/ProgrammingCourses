# Python Slot Machine

def spin_row():
    pass

def print_row():
    pass

def get_payout(payout):
    print(f"Your payout is: ${payout:.2f}")
    return payout

def main():
    balance = 100
    win = 0
    is_running = True
    print("Python Slot Machine")
    print("Symbols: 🍒 🍊 🍋 🍉 🍇 🍓")
    print(f"Your balance is: ${balance:.2f}")
    while is_running:
        print(f"Your balance is: ${balance:.2f}")
        print("Press 1. to spin")
        print("Press 2. to payout")
        print("Press 3. to exit")
        option = int(input("Enter option: "))
        match option:
            case 1:
                bet = input("Enter bet amount: ")
                if not bet.isdigit():
                    print("Invalid bet amount")
                    continue
                bet = int(bet)
                if bet > balance:
                    print("Insufficient funds")
                    continue
                balance -= bet

                spin_row()
            case 2:
                get_payout()
                balance += get_payout(win)
            case 3:
                is_running = False
                print(f"You ended your session with ${balance:.2f}")
                print("Goodbye!")
            case _:
                print("Invalid option")

if __name__ == '__main__':
    main()