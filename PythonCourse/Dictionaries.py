# dictionary = a collection of {key:value} pairs, ordered, changeable, no duplicates

# Dictionary

capitals = {"USA": "Washington D.C.",
            "France": "Paris",
            "Germany": "Berlin",
            "Italy": "Rome"}

print(capitals.get("USA"))
print(capitals.get("Japan"))

if capitals.get("Japan"):
    print("That capital exists")
else:
    print("That capital does not exist")

capitals.update({"Japan": "Tokyo"})
print(capitals)

capitals.pop("Italy")
print(capitals)

keys = capitals.keys() #object that resembles a list
print(keys)

for key in capitals.keys():
    print(key)

values = capitals.values() #object that resembles a list
print(values)

for key, value in capitals.items():
    print(key, value)



capitals.popitem() # remove the last item
capitals.clear() # remove all items