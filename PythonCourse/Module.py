# Module = a file containing code you want to include in your program
#          use 'import' to include a module (built-in or custom)
#          useful to break up a large program into reusable separate files

# print(help("modules"))

# import math
# import math as m
# from math import pi
# print(math.pi)

import ExampleModule
print(ExampleModule.pi)

print(ExampleModule.square(5))
print(ExampleModule.cube(10))
print(ExampleModule.circumference(5))
print(ExampleModule.surface_area(5))