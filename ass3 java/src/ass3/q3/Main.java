package ass3.q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();
        try { System.out.println("Result: " + calculate(first, second, operator)); }
        catch (ArithmeticException | IllegalArgumentException exception) { System.out.println("Error: " + exception.getMessage()); }
        scanner.close();
    }

    private static double calculate(double first, double second, char operator) {
        switch (operator) {
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second;
            case '/':
                if (second == 0) throw new ArithmeticException("Division by zero is not allowed.");
                return first / second;
            default: throw new IllegalArgumentException("Invalid operator.");
        }
    }
}
