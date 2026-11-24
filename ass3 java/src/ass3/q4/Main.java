package ass3.q4;

import java.util.Scanner;

class InvalidMarksException extends Exception { InvalidMarksException(String message) { super(message); } }

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter marks in five subjects: ");
            double total = 0;
            for (int i = 0; i < 5; i++) {
                double mark = scanner.nextDouble();
                if (mark < 0 || mark > 100) throw new InvalidMarksException("Each mark must be between 0 and 100.");
                total += mark;
            }
            double percentage = total / 5;
            String grade = percentage >= 90 ? "A" : percentage >= 75 ? "B" : percentage >= 60 ? "C" : percentage >= 40 ? "D" : "F";
            System.out.printf("Name: %s%nTotal: %.2f%nPercentage: %.2f%%%nGrade: %s%n", name, total, percentage, grade);
        } catch (InvalidMarksException exception) { System.out.println("Error: " + exception.getMessage()); }
        scanner.close();
    }
}
