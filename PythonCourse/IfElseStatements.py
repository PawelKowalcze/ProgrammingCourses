

age = int(input("Enter your age: "))

if age >= 18:
    print("You are an adult")
elif age <= 13:
    print("You are a child")
else:
    print("You are a teenager")

response = input("Do you want to continue? (yes/no) ")
if response == "yes":
    print("You are still here")
else:
    print("Goodbye")

for_sale = True
if for_sale:
    print("The product is for sale")
else:
    print("The product is not for sale")