word = "APPLE"

letter = input("Enter a letter: ").upper()

if letter in word: # in / not in
    print(f"{letter} is in the word")
else:
    print(f"{letter} is not in the word")


grades = {
    "Paweł": 90,
    "Anna": 80,
    "Jan": 70}

student = input("Enter a student name: ")

if student in grades:
    print(f"{student} has a grade of {grades[student]}")
else:
    print("Student not found")