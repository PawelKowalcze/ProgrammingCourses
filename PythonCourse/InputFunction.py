# input()

name = input("Enter your name: ")
age = int(input("Enter your age: "))
print("Hello " + name)
print(f"Hello {name}")
print(f"you are {age} years old")

# Area of a rectangle
length = float(input("Enter the length of the rectangle: "))
width = float(input("Enter the width of the rectangle: "))

area = length * width;
print(f"The area of the rectangle is {area}")

# Shopping cart

price = float(input("What is the price of the product? "))
quantity = int(input("How many products do you want to buy? "))

total = price *quantity
print(f"The total price is {total}")