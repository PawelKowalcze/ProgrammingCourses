# print(dir())
# print(__name__)

from Script2 import *

# print(__name__)

def favourite_food(food):
    print(f"My favourite food is {food}.")

def main():
    print("Hello from script1")
    favourite_food("pizza")


if __name__ == '__main__':
    main()