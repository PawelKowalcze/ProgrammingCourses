# if __name__ == '__main__': this script can be imported or run as a standalone script
#                            functions and classes in this module can be reused without the main block of code executing

# Good practise ( code is modular,
# helps readability,
# leaves no global variables,
# avoid unintended execution of code)

# example: library = import library for functionality
#                    when running library directly, display a help page

import Script1
import Script2

Script1.favourite_food("pasta")
Script2.favourite_drink("tea")