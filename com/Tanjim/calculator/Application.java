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
                System.out.println("\nEnter operation (add, subtract, multiply, divide, factorial) or 'exit' to quit:");
                String operation = scanner.next();

                if (operation.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting calculator...");
                    break;
                }

                if (!operation.equalsIgnoreCase("factorial")) {
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
                            if (num2 != 0) {
                                System.out.println("Result: " + divide(num1, num2));
                            } else {
                                System.out.println("Cannot divide by zero.");
                            }
                            break;
                        default:
                            System.out.println("Invalid operation.");
                            break;
                    }
                } else {
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Result: " + factorial(num));
                }
            }
            scanner.close();
        }
    }

    private static void handleArguments(String[] args) {
        String operation = args[0];

        if (operation.equalsIgnoreCase("factorial") && args.length == 2) {
            double num = Double.parseDouble(args[1]);
            System.out.println("Result: " + factorial(num));
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
                    if (num2 != 0) {
                        System.out.println("Result: " + divide(num1, num2));
                    } else {
                        System.out.println("Cannot divide by zero.");
                    }
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
        return a / b;
    }

    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}


