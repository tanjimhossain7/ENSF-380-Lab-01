package com.Tanjim.calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Process CLI arguments
            handleArguments(args);
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            while (true) {
                // Display menu options
                System.out.println("\nEnter operation (add, subtract, multiply, divide, power, sqrt, log, log10, exp, sin, cos, tan, factorial, permutations) or 'exit' to quit:");
                String operation = scanner.next();

                if (operation.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting calculator...");
                    break;
                }

                if (operation.equalsIgnoreCase("permutations")) {
                    // Handle permutations
                    System.out.print("Enter total number of elements (n): ");
                    int n = scanner.nextInt();
                    System.out.print("Enter number of items to select (r): ");
                    int r = scanner.nextInt();
                    try {
                        System.out.println("Result: " + permutationsRecursive(n, r));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    // Handle other operations
                    handleOperation(operation, scanner);
                }
            }
            scanner.close();
        }
    }

    // Handle operations based on user input
    private static void handleOperation(String operation, Scanner scanner) {
        System.out.print("Enter number: ");
        double num = scanner.nextDouble();
        switch (operation.toLowerCase()) {
            case "add":
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                System.out.println("Result: " + add(num, num2));
                break;
            case "subtract":
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
                System.out.println("Result: " + subtract(num, num2));
                break;
            case "multiply":
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
                System.out.println("Result: " + multiply(num, num2));
                break;
            case "divide":
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
                try {
                    System.out.println("Result: " + divide(num, num2));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "power":
                System.out.print("Enter exponent: ");
                num2 = scanner.nextDouble();
                System.out.println("Result: " + power(num, num2));
                break;
            case "sqrt":
                System.out.println("Result: " + squareRoot(num));
                break;
            case "log":
                System.out.println("Result: " + log(num));
                break;
            case "log10":
                System.out.println("Result: " + log10(num));
                break;
            case "exp":
                System.out.println("Result: " + exp(num));
                break;
            case "sin":
                System.out.println("Result: " + sin(num));
                break;
            case "cos":
                System.out.println("Result: " + cos(num));
                break;
            case "tan":
                System.out.println("Result: " + tan(num));
                break;
            case "factorial":
                System.out.println("Result: " + factorial((int) num));
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
    }

    // Handle operations based on command-line arguments
    private static void handleArguments(String[] args) {
        String operation = args[0];

        if (operation.equalsIgnoreCase("permutations") && args.length == 3) {
            int n = Integer.parseInt(args[1]);
            int r = Integer.parseInt(args[2]);
            try {
                System.out.println("Result: " + permutationsRecursive(n, r));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            // Handle other operations
            // ...
        }
    }

    // Method to calculate permutations recursively
    public static long permutationsRecursive(int n, int r) {
        if (r > n) {
            throw new IllegalArgumentException("r cannot be greater than n.");
        }
        if (r < 0 || n < 0) {
            throw new IllegalArgumentException("n and r cannot be negative.");
        }
        if (r == 0) {
            return 1;
        }
        return n * permutationsRecursive(n - 1, r - 1);
    }

    // Method to add two numbers
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to subtract two numbers
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method to multiply two numbers
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method to divide two numbers
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return a / b;
    }

    // Method to calculate power
    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Method to calculate square root
    public static double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative number.");
        }
        return Math.sqrt(a);
    }

    // Method to calculate natural logarithm
    public static double log(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Cannot take the log of a non-positive number.");
        }
        return Math.log(a);
    }

    // Method to calculate base-10 logarithm
    public static double log10(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Cannot take the log10 of a non-positive number.");
        }
        return Math.log10(a);
    }

    // Method to calculate exponential
    public static double exp(double a) {
        return Math.exp(a);
    }

    // Method to calculate sine of an angle in degrees
    public static double sin(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    // Method to calculate cosine of an angle in degrees
    public static double cos(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    // Method to calculate tangent of an angle in degrees
    public static double tan(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }

    // Method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot calculate the factorial of a negative number.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


