"""module main1 - pres standard --- """
# ----------------------------
# Part 1 - import library 
# 			and constant value
# -----------------------

# system library
import sys

# constant
REPEAT=10
A,B,C=range(10,15,2)

# ----------------------------
# Part 2 - all functions
# 			
# -----------------------

def my_type(var):
	""" return id of variable var"""
	return type(var)
	

def my_id(var):
	""" return id of variable var"""
	return id(var)

	
def my_main():
	""" call from main entry """
	
	# 1 - call functions and print results
	print("1 ",'-'*50)
	print(my_id('toto'))
	print(my_type('toto'))
	
	# 2 - iteration
	print("2 ",'-'*50)
	c = "t"*15
	for var in ("a", 3.14159, True, -4, 2+3j, (True, 4), ["e", 0, False], 
		{ "a":10, "b":c }, {1, 2, 4}, object(), None):
		print(var, end=' -> ')
		print(my_id(var),end=' - ')
		print(my_type(var))
		print("-"*40)
		
	# 3 - something wrong ?
	print("3 ",'-'*50)
	a = 10
	print("id ->", my_id(a))
	print("id ->", my_id(10))
	
	# 4 - Other loop
	print("4 ",'-'*50)
	start = REPEAT
	while start:
		print("Start is", start)
		start -= 1

	# 5 - function is an object
	print("5 ",'-'*50)
	for func in (my_id, my_type, hex):
		print(func(A))
	
	
# -----------------------
# Part 3 - main entry 
# -----------------------
if __name__ == "__main__":
    """
    """
    print(sys.version)
    my_main()
