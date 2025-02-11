# Iterables = An object/collection that can return its elements one at a time, allowing it to be iterated over in a loop

numbers = [1, 2, 3, 4, 5]

for number in reversed(numbers):
    print(number, end=" ")

fruits = {"apple", "banana", "cherry"}

for fruit in fruits:
    print(fruit, end=" ")

name = "Paweł"

for character in name:
    print(character, end=" ")

my_dictionary = {"name": "Paweł",
                 "age": 20,
                 "city": "Warsaw"}
print()
for key, value in my_dictionary.items():
    print(f"{key}: {value}")
