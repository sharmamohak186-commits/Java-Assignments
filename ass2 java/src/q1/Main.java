package q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodOrder[] orders = new FoodOrder[2];

        System.out.println("FOOD DELIVERY ORDER SYSTEM");
        for (int i = 0; i < orders.length; i++) {
            System.out.println("\nEnter details for order " + (i + 1));
            int orderId = readPositiveInt(scanner, "Order ID: ");
            String customerName = readName(scanner, "Customer name: ");
            double amount = readPositiveDouble(scanner, "Order amount (Rs.): ");
            boolean premium = readYesNo(scanner, "Premium order? (y/n): ");
            orders[i] = OrderUtility.generateOrder(orderId, customerName, amount, premium);
        }

        System.out.println("\nORDER SUMMARY");
        for (FoodOrder order : orders) {
            System.out.println(order.summary());
        }
        FoodOrder.displayTotalOrders();
        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value > 0) return value;
            } else {
                scanner.nextLine();
            }
            System.out.println("Enter a positive whole number.");
        }
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (OrderUtility.validateAmount(value)) return value;
            } else {
                scanner.nextLine();
            }
            System.out.println("Enter an amount greater than zero.");
        }
    }

    private static String readName(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            if (OrderUtility.validateCustomerName(name)) return name;
            System.out.println("Customer name cannot be empty.");
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
