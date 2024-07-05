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
                System.out.println("\nEnter operation (add, subtract, multiply, divide, power, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
                String operation = scanner.next();

                if (operation.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting calculator...");
                    break;
                }

                if (operation.equalsIgnoreCase("sqrt") || operation.equalsIgnoreCase("log") || 
                    operation.equalsIgnoreCase("log10") || operation.equalsIgnoreCase("sin") || 
                    operation.equalsIgnoreCase("cos") || operation.equalsIgnoreCase("tan") || 
                    operation.equalsIgnoreCase("factorial")) {
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();

                    switch (operation.toLowerCase()) {
                        case "sqrt":
                            System.out.println("Result: " + squareRoot(num));
                            break;
                        case "log":
                            System.out.println("Result: " + log(num));
                            break;
                        case "log10":
                            System.out.println("Result: " + log10(num));
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
                            System.out.println("Result: " + factorial((int)num));
                            break;
                        default:
                            System.out.println("Invalid operation.");
                            break;
                    }
                } else {
                    System.out.print("Enter first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = scanner.nextDouble();

                    switch (operation.toLowerCase()) {
                        case "add":
                            System.out.println("Result: " + add(num1, num2));
                            break;
                        case "subtract":
                            System.out.println("Result: " + subtract(num1, num2));
                            break;
                        case "multiply":
                            System.out.println("Result: " + multiply(num1, num2));
                            break;
                        case "divide":
                            try {
                                System.out.println("Result: " + divide(num1, num2));
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case "power":
                            System.out.println("Result: " + power(num1, num2));
                            break;
                        default:
                            System.out.println("Invalid operation.");
                            break;
                    }
                }
            }
            scanner.close();
        }
    }

    private static void handleArguments(String[] args) {
        String operation = args[0];

        if (operation.equalsIgnoreCase("factorial") && args.length == 2) {
            double num = Double.parseDouble(args[1]);
            System.out.println("Result: " + factorial((int)num));
        } else if (operation.equalsIgnoreCase("sqrt") && args.length == 2) {
            double num = Double.parseDouble(args[1]);
            System.out.println("Result: " + squareRoot(num));
        } else if (operation.equalsIgnoreCase("log") && args.length == 2) {
            double num = Double.parseDouble(args[1]);
            System.out.println("Result: " + log(num));
        } else if (operation.equalsIgnoreCase("log10") && args.length == 2) {
            double num = Double.parseDouble(args[1]);
            System.out.println("Result: " + log10(num));
        } else if (operation.equalsIgnoreCase("sin") && args.length == 2) {
            double degrees = Double.parseDouble(args[1]);
            System.out.println("Result: " + sin(degrees));
        } else if (operation.equalsIgnoreCase("cos") && args.length == 2) {
            double degrees = Double.parseDouble(args[1]);
            System.out.println("Result: " + cos(degrees));
        } else if (operation.equalsIgnoreCase("tan") && args.length == 2) {
            double degrees = Double.parseDouble(args[1]);
            System.out.println("Result: " + tan(degrees));
        } else if (args.length == 3) {
            double num1 = Double.parseDouble(args[1]);
            double num2 = Double.parseDouble(args[2]);

            switch (operation.toLowerCase()) {
                case "add":
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case "subtract":
                    System.out.println("Result: " + subtract(num1, num2));
                    break;
                case "multiply":
                    System.out.println("Result: " + multiply(num1, num2));
                    break;
                case "divide":
                    try {
                        System.out.println("Result: " + divide(num1, num2));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "power":
                    System.out.println("Result: " + power(num1, num2));
                    break;
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        } else {
            System.out.println("Invalid number of arguments.");
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative number.");
        }
        return Math.sqrt(a);
    }

    public static double log(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Cannot take the log of a non-positive number.");
        }
        return Math.log(a);
    }

    public static double log10(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Cannot take the log10 of a non-positive number.");
        }
        return Math.log10(a);
    }

    public static double sin(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double cos(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double tan(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }

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

