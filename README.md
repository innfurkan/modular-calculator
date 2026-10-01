# Modular Calculator

A Java command-line application for solving modular arithmetic problems and explaining the solution process step by step.

This project started as a simple modular calculator and is being developed into an interactive learning tool that connects Java programming with concepts from Discrete Mathematics and Number Theory.

## Current Features

- Basic modular arithmetic:
  - `a mod(c)`
- Modular exponentiation:
  - `b^e mod(c)`
- Binary modular exponentiation for efficient calculations
- Support for negative dividends using `Math.floorMod()`
- Input validation and exception handling
- Reusable Yes/No input checking
- Interactive learning mode
- Step-by-step explanation for:
  - Basic modulo calculations
  - Binary modular exponentiation

## Example

### Basic Modulo

```text
Enter a number or exponential expression: 17
Enter modulus c: 5

17 mod(5) = 2
```

Learning mode explains:
17 = (5 \* 3) + 2

The remainder after dividing 17 by 5 is 2.

Therefore:
17 mod(5) = 2

Modular Exponentiation
Enter a number or exponential expression: 5^13
Enter modulus c: 7

5^13 mod(7) = 5

The learning mode demonstrates the binary modular exponentiation algorithm step by step.
How It Works
For large exponent calculations, the program uses binary modular exponentiation instead of directly calculating the full power.
For example:
5^13 mod(7)

The exponent is repeatedly divided by 2 while the base is squared and reduced modulo 7.
This allows the program to calculate modular powers efficiently without creating extremely large intermediate values.
Technologies and Concepts

- Java
- Scanner
- ArrayList
- Methods
- Exception handling
- Input validation
- Modular arithmetic
- Binary exponentiation
- Discrete Mathematics

Project Development
The original version of this project contained most of the calculation logic directly inside the main() method.
The project has since been improved by:

- Separating functionality into reusable methods
- Replacing the original exponentiation logic with binary modular exponentiation
- Adding error handling
- Adding reusable input validation
- Adding an interactive learning mode
- Improving the overall structure of the application

Roadmap
Future improvements may include:

- Refactoring calculation data into a ModularProblem class
- Greatest Common Divisor (GCD)
- Euclidean Algorithm
- Extended Euclidean Algorithm
- Modular inverses
- Linear congruence solving
- Chinese Remainder Theorem
- Improved expression parsing
- Automated tests
- Graphical user interface

Author
Furkan Inan
Computer Engineering Student
