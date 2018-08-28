# errorTree
A way to log functions with parameters

How it works ?

The program uses trees to remember all function calls that have a common ancestor and prints a full tree when asked by user.

What are Function and Parameter ?

Function is an object that retains information about a function:
-name
-parameters (a list of parameters)

Parameter is an object that retains information about a parameter of a function:
- name
- value

How to use ?

You can initialize the log file with:
- Logger.initialize(...)

In the root function use the method:
- Controller.startTrace(Function function)
You need to create a Function object using your function data
You can have more root functions

When in a child function call method:
- Controller.addFunction(String parentFunction, Function function)
"parentFunction" is the name of the function that called the current function
You need to create a Function object using your function data

@Deprecated
When you need information about previous functions called use method:
- Controller.printAll(String motherFunction)
"motherFunction" is the name of the root function

When you catch an exception you can print the error tree using method:
- Controller.printException(String parentFunction, Exception exception)
"parentFunction" is the name of the function where you caught the exception
"exception" is the exception you caught

When you want to end a function call method:
- Controller.endTrace(String motherFunction,boolean printAll)
"motherFunction" is the name of the root function
"printAll" determines if the tree of functions is printed or not

Example:
- Run the test function.
