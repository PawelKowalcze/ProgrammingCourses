# indexing [start : end : step]


credit_number = "1234-5678-9012-3456"

print (credit_number[0:4]) # 0 can be omitted [:4]
print(credit_number[5:9])
print(credit_number[10:])

print(credit_number[-2]) # every second character

print(credit_number[::2]) # every second character

last_four = credit_number[-4:]
print(last_four)
last_four = credit_number[len(credit_number)-4:]
print(last_four)

print(credit_number[::-1]) # reverse the string