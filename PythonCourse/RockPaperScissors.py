import random
options = ("rock", "paper", "scissors")
player = None
computer = random.choice(options)
playing = True
while playing:
    while player not in options:
        player = input("Enter your choice (rock, paper, scissors): ").lower()

    print(f"Player: {player}")
    print(f"Computer: {computer}")

    if player == computer:
        print("It's a tie!")
    elif player == "rock" and computer == "scissors":
        print("Player wins!")
    elif player == "paper" and computer == "rock":
        print("Player wins!")
    elif player == "scissors" and computer == "paper":
        print("Player wins!")
    else:
        print("Computer wins!")
    choice = input("Do you want to play again? (Y/N)").capitalize()
    if choice != "Y":
        playing = False
    else:
        player = None
        computer = random.choice(options)

print("Thanks for playing!")