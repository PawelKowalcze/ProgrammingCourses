fruits = ["apple", "banana", "cherry"]
vegetables = ["carrot", "beans", "spinach"]
meats = ["beef", "chicken", "pork"]

groceries = [fruits, vegetables, meats]

print(groceries[0][1])

for category in groceries:
    for item in category:
        print(item, end=" ")
    print()


num_pad = (
    (7, 8, 9),
    (4, 5, 6),
    (1, 2, 3),
    ("#", 0, "*")
)

for row in num_pad:
    for key in row:
        print(key, end=" ")
    print()
