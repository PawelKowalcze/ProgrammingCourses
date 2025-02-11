menu = {"pizza": 4.00,
        "hotdog": 3.00,
        "popcorn": 2.00,
        "soda": 1.00,
        "candy": 1.50
        }


cart = []
total = 0


print("----------MENU----------")
for key, value in menu.items():
    print(f"{key:10}: ${value:.2f}")
print("------------------------")

while True:
    food = input("Select an item (q to quit): ")
    if food.lower() == "q":
        break
    elif menu.get(food) is not None:
        cart.append(food)
        total += menu[food]

print("Your cart:")
for item in cart:
    print(item, end=" ")

print(f"\nTotal: ${total:.2f}")