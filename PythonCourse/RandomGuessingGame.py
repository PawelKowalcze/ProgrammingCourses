import random
lowest_number = 1
highest_number = 100

answer = random.randint(lowest_number, highest_number)
print(answer)

guesses = 0
is_running = True

print("welcome to the random number guessing game")
print(f"Guess a number between {lowest_number} and {highest_number}")

while is_running:
    guess = input("Enter your guess: ")
    if guess.isdigit():
        guess = int(guess)
        guesses += 1

        if guess < lowest_number or guess > highest_number:
            print(f"Please enter a number between {lowest_number} and {highest_number}")
            continue
        elif guess < answer:
            print("Too low")
        elif guess > answer:
            print("Too high")
        else:
            print(f"Congratulations! You guessed the number in {guesses} guesses")
            is_running = False
    else:
        print("Invalid input. Please enter a number")
        continue

