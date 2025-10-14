# variable scope = where it is visible and accessible
# scope resolution = local -> enclosed -> global -> built-in

def func1():
    x = 1
    print(x)

def func2():
    y = 2
    print(y)


func1()
func2()