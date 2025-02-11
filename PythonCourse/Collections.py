#Collections:
#1. List = [] - ordered and changeable
#3. Set = {} - unordered and immutable
#3. Tuple = () - ordered and unchangeable


# List
fruits = ["apple", "banana", "cherry"]

# print(dir(fruits))
# print(help(fruits))

print(len(fruits))


for fruit in fruits:
    print(fruit)

print(fruits.index("banana"))
print(fruits.count("banana"))
fruits[1] = "orange"
fruits.append("mango") # add to the end of the list
fruits.remove("apple") # remove the first occurrence of the item
fruits.insert(0, "kiwi") # insert at the specified index
fruits.sort() # sort the list
fruits.reverse() # reverse the list
fruits.clear() # remove all items from the list
for fruit in fruits:
    print(fruit)


# Set
cars = {"Toyota", "Ford", "Chevy"}

print(len(cars))
print("Toyota" in cars)
print("Mazda" in cars)
cars.add("Mazda")
cars.remove("Ford")
cars.pop() # remove the last item
cars.clear() # remove all items

# Tuple
fruits = ("apple", "banana", "cherry")
print(len(fruits))
print("apple" in fruits)

print(fruits.count("apple"))