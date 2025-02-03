# String methods

name = input("Enter your name: ")
phone_number = input("Enter your phone number: ")
length = len(name) # length of the string
find = name.find("a") # index of a first occurrence
rfind = name.rfind("a") # index of a last occurrence
name = name.capitalize() # capitalize the first letter
name = name.upper() # capitalize all letters
name = name.lower() # lower case all letters
result = name.isdigit() # check if all characters are digits
result = name.isalpha() # check if all characters are alphabetic
phone_number.count("1") # count the number of ones in the phone number, return int
phone_number = phone_number.replace("-", " ") # replace all dashes with space
print(phone_number)
print(f"There are {phone_number.count("1")} ones in the phone number")
print(length)
print(find)
print(rfind)
print(name)
print(result)

#print(help(str))

# Validate user input
# 1. username is no more than 12 characters
# 2. username must not contain spaces
# 3. username must not contain digits

username = input("Enter your username: ")
if len(username) <= 12 and username.count(" ") == 0 and username.isalpha():
    print("Username is valid")
else:
    print("Username is invalid")
