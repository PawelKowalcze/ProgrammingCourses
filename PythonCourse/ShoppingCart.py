#shopping cart
foods = []
prices = []
total = 0

while True:
    food = input("Enter the food you want to buy: ")
    if food.lower() == "q":
        break
    else:
        foods.append(food)
        price = float(input("Enter the price of the food: "))
        prices.append(price)

print("Your shopping cart:")
for food in foods:
    print(food, end=" ")

for price in prices:
    total += price

print(f"\nTotal: ${total:.2f}")