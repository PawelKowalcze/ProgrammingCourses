# keyword arguments = an argument preceded by an identifier
# helps with readability
# order of arguments does not matter

def hello(greeting, title, first, last):
    print(f"{greeting} {title}{first} {last}")


hello(title="Mr.", first="Paweł", last="Kowalcze", greeting="Hello")

print("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", sep=" - ")  # build in functions usually have keyword arguments


def phone_number(country_code, area_code, number):
    return f"+{country_code}-{area_code}-{number}"


num = phone_number(country_code=48, area_code=22, number=1234567)
print(num)
