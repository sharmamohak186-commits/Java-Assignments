package ass3.q2;

public class Main {
    public static void main(String[] args) {
        try {
            try {
                int[] numbers = {10, 20};
                System.out.println(numbers[5]);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Inner catch: invalid array index.");
                try { Integer.parseInt("abc"); } catch (NumberFormatException nested) { System.out.println("Nested catch: invalid number."); }
            }
        } catch (Exception exception) {
            System.out.println("Outer catch: " + exception.getMessage());
        } finally {
            System.out.println("Nested try-catch demonstration complete.");
        }
    }
}
