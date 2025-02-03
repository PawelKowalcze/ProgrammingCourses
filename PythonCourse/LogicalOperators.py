# Logical operators: or, and, not

temp = float(input("Enter the temperature: "))
is_raining = input("Is it raining? (True/False) ")


if temp > 35 or temp < 0 or is_raining == "True":
    print("The event must be cancelled")


if 30 > temp > 25 and is_raining == "False":
    print("It is hot outside")

is_raining = True
if not is_raining:
    print("It is not raining")
else:
    print("It is raining")