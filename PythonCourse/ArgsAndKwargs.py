# *args = allows you to pass multiple non-keyworded arguments to a function -> tuple
# **kwargs = allows you to pass multiple keyworded arguments to a function  -> dictionary

def add(*nums):
    # print(type(args))
    # print(args)
    total = 0
    for num in nums:
        total += num
    return total
print(add(1,2,3,4,5,6,7,8,9,10))

def display_name(*args):
    for arg in args:
        print(arg, end=" ")

display_name("Paweł", "Kowalcze", "is", "a", "programmer\n")

def print_address(**kwargs):
    # print(type(kwargs))
    for key, value in kwargs.items():
        print(f"{key}: {value}")
print_address(street="123 Main Street",
              city="New York",
              state="NY",
              zip="10001")



def shipping_labe(*args, **kwargs):
    for arg in args:
        print(arg, end=" ")
    print()
    if "apt" in kwargs:
        print(f"{kwargs.get('street')}, {kwargs.get('apt')}")
    else:
        print(f"{kwargs.get('street')}")
    print(f"{kwargs.get('city')}, {kwargs.get('state')}, {kwargs.get('zip')}")

shipping_labe("Paweł", "Kowalcze",
              street="123 Main Street",
              apt= "1A",
              city="New York",
              state="NY",
              zip="10001",
              country="USA")