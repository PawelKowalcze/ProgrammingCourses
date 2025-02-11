# default arguments = A default argument is a parameter that assumes a default value if a value is not provided in the function call for that argument.

def net_price(list_price, discount=0, tax=0.05):
    return list_price * (1 - discount) * (1 + tax)

print(net_price(500, 0.05))
