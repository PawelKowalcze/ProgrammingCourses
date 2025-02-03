import math
def addition(a, b):
    return a + b

def subtraction(a, b):
    return a - b

def multiplication(a, b):
    return a * b

def division(a, b):
    return a / b

def squareroot(a):
    return math.sqrt(a)

def power(a, b):
    return math.pow(a, b)

is_running = True
while (is_running):
    print("Hello")
    print("1. Addition \n 2. Subtraction \n 3. Multiplication \n 4. Division \n 5. Square root \n 6. Power \n 7. Exit")
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    choice = int(input("Enter your choice: "))
    if choice == 1:
        print(f"Result is {addition(num1, num2)}")
    elif choice == 2:
        print(f"Result is {subtraction(num1, num2)}")
    elif choice == 3:
        print(f"Result is {multiplication(num1, num2)}")
    elif choice == 4:
        print(f"Result is {division(num1, num2)}")
    else:
        is_running = False
        print(is_running)

print("The programm has ended")