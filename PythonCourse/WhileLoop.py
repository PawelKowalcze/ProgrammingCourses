name = ""

while name == "":
    print("You did not enter your name")
    name = input("Enter your name: ")
print(f"Hello {name}")

age = int(input("Enter your age: "))
while age < 0:
    print("You entered a negative number")
    age = int(input("Enter your age: "))
print(f"You are {age} years old")

food = input("Enter your favorite food: (q to quit)")
while food != "q":
    print(f"Your favorite food is {food}")
    food = input("Enter your favorite food: (q to quit)")
print("Goodbye")

num = int(input("Enter a number between 1-10: "))
while num < 1 or num > 10:
    print("Invalid number")
    num = int(input("Enter a number between 1-10: "))
print(f"You entered {num}")