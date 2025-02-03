# format specifiers = {value:flags} format a value vased on what flags are set

# .(number)f = round to that many decimal places (fixed point)
# :(number) = allocate that many spaces
# :03 = allocate and zero pad that many spaces
# :< = left justify
# :> = right justify
# :^ = center allign
# :+ = use a plus sign to indicate positive value
# := = use sign to leftmost position
# : = insert a space before positive numbers
# :, = comma separator

price1 = 3452.1231
price2 = -93953.123
price3 = 12.11
# decimal places
print(f"Price 1: ${price1:.2f}")
print(f"Price 2: ${price2:.2f}")
print(f"Price 3: ${price3:.3f}")
#space
print(f"Price 1: ${price1:010}")
print(f"Price 2: ${price2:011}")
print(f"Price 3: ${price3:15}")

print(f"Price 1: ${price1:<10}")
print(f"Price 2: ${price2:^11}")
print(f"Price 3: ${price3:>15}")

print(f"Price 1: ${price1:+}")
print(f"Price 2: ${price2:+}")
print(f"Price 3: ${price3:+}")

print(f"Price 1: ${price1: }")
print(f"Price 2: ${price2: }")
print(f"Price 3: ${price3: }")

print(f"Price 1: ${price1:,}")
print(f"Price 2: ${price2:,}")
print(f"Price 3: ${price3:,}")

print(f"Price 1: ${price1:+,.2f}")
print(f"Price 2: ${price2:011}")
print(f"Price 3: ${price3:15}")