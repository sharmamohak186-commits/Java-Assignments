package library.main;

import java.util.Scanner;
import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.BookService;
import library.service.DigitalResourceService;
import library.service.Printable;
import library.utility.InputValidator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryResource[] resources = new LibraryResource[2];
        Printable[] printableResources = new Printable[2];

        System.out.println("LIBRARY RESOURCE MANAGEMENT SYSTEM");
        System.out.println("Library: " + LibraryResource.getLibraryName());
        for (int i = 0; i < resources.length; i++) {
            System.out.println("\nEnter details for resource " + (i + 1));
            int id = readResourceId(scanner);
            String title = readText(scanner, "Title: ");
            String author = readText(scanner, "Author: ");
            boolean digital = readYesNo(scanner, "Digital resource? (y/n): ");

            if (digital) {
                DigitalResource resource = new DigitalResource(id, title, author);
                resources[i] = resource;
                printableResources[i] = new DigitalResourceService(resource);
            } else {
                Book book = new Book(id, title, author);
                resources[i] = book;
                printableResources[i] = new BookService(book);
            }
        }

        System.out.println("\nRESOURCE DETAILS AND FINES");
        for (int i = 0; i < resources.length; i++) {
            printableResources[i].printDetails();
            int overdueDays = readOverdueDays(scanner);
            System.out.printf("Overdue days: %d | Fine: Rs. %.2f%n",
                    overdueDays, resources[i].calculateFine(overdueDays));
        }
        scanner.close();
    }

    private static int readResourceId(Scanner scanner) {
        while (true) {
            System.out.print("Resource ID: ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();
                if (InputValidator.isValidResourceId(id)) return id;
            } else {
                scanner.nextLine();
            }
            System.out.println("Resource ID must be greater than zero.");
        }
    }

    private static int readOverdueDays(Scanner scanner) {
        while (true) {
            System.out.print("Overdue days: ");
            if (scanner.hasNextInt()) {
                int days = scanner.nextInt();
                scanner.nextLine();
                if (InputValidator.isValidOverdueDays(days)) return days;
            } else {
                scanner.nextLine();
            }
            System.out.println("Overdue days cannot be negative.");
        }
    }

    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("This field cannot be empty.");
        }
    }

    private static boolean readYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y") || answer.equals("yes")) return true;
            if (answer.equals("n") || answer.equals("no")) return false;
            System.out.println("Enter y or n.");
        }
    }
}
