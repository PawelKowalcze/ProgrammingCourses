import math

friends = 0
friends += 2
friends -= 1
friends = friends * 3
friends *= 2
friends /= 2
friends = friends ** 2
friends **= 2
friends = friends % 2
print(friends)


x = 3.1
y = - 2.7
z = 5

result = round(x, 1)
result = round(abs(y))
result = pow(z, 2)

result = max(x, y, z)
result = min(x, y, z)

print(result)

print(math.pi)
print(math.e)
print(math.sqrt(z))

print(math.ceil(x))
print(math.floor(x))

# Obwód koła
radius = float(input("Enter the radius of the circle: "))

c = 2 * math.pi * radius
print(f"The circumference of the circle is {round(c,3)}")

area = math.pi * math.pow(radius, 2)
print(f"The area of the circle is {area}")

# Przeciwprostokątna

a = float(input("Enter the first side of the triangle: "))
b = float(input("Enter the second side of the triangle: "))

c = math.sqrt(math.pow(a, 2) + math.pow(b, 2))
print (f"The hypotenuse of the triangle is {c}")