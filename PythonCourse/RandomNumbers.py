import random

# print(help(random))
low = 1
high = 100
options = ("rock", "paper", "scissors")
cards = ["ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"]


# number = random.randint(low, high)
# number = random.random()
# mychoice = random.choice(options)
random.shuffle(cards)
print(cards)