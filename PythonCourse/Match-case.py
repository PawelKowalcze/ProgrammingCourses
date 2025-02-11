def day_of_the_week(day):
    match day:
        case 1:
            return "Monday"
        case 2:
            return "Tuesday"
        case 3:
            return "Wednesday"
        case 4:
            return "Thursday"
        case 5:
            return "Friday"
        case 6:
            return "Saturday"
        case 7:
            return "Sunday"
        case _:  # default case
            return "Invalid day"


print(day_of_the_week(7))


def is_weekend(day):
    match day:
        case "Sunday" | "Saturday":
            return True
        case _:
            return False

print(is_weekend("Saturday"))