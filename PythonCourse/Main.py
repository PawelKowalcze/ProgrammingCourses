#Basics

print("Hello World")
print("I like volleyball")


#Strings
first_name = "Katie"
second_name = "Hunt"
print(first_name + " " + second_name)
print(f"Hello {first_name} {second_name}")

#integers

age = 20
quantity = 1
print (f"you are {age} years old")

#floats
price = 10.99
print (f"the price of the product is {price}")

#boolean
is_today_raining = True
is_student = False
print(is_today_raining)
print(is_student)
if is_today_raining:
    print("Take an umbrella")
else:
    print("You don't need an umbrella")

# Typecasting str(), int(), float(), bool()
name = "Pawel"
age = 20
gpa = 3.5
is_student = True
print(type(gpa))

gpa = int(gpa)
print(type(gpa))
print(gpa)

name = bool(name) #if its not empty it will be true
print(name)

