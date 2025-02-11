for i in range(1,11):
    print(i) # 1-10


for i in reversed(range(1,11)):
    print(i)

for i in range(1,11, 2):
    print(i)

credit_card = "1234-5678-9012-3456"

for x in credit_card:
    print(x)

for i in range(1,21):
    if i == 13:
        continue
    else:
        print(i)