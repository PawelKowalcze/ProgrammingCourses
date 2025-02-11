# List comprehension = A concise way to create lists in Python
#                       Compact and easier to read than traditional for loops
#                       [expression for value in iterable if condition]

double = []
for num in range(1, 11):
    double.append(num * 2)
print(double)

numbers = [x * 2 for x in range(1, 11)]
print(numbers)

triples = [x * 3 for x in range(1, 11)]
print(triples)

squares = [z*z for z in range(1, 11)]
print(squares)

fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
fruit_chars = [fruit[0].capitalize() for fruit in fruits]
print(fruit_chars)


numbers = [-1,2,-4,10,-7,9]
positive = [num for num in numbers if num >= 0]
negative = [num for num in numbers if num < 0]
even_numbers = [num for num in numbers if num % 2 == 0]
odd_numbers = [num for num in numbers if num % 2 != 0]
print(positive)


