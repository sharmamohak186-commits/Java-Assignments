package ass3.q1;

public class Main {
    public static void main(String[] args) {
        demonstrate("ArithmeticException", () -> { int divisor = 0; int ignored = 10 / divisor; });
        demonstrate("NullPointerException", () -> { String value = null; value.length(); });
        demonstrate("ArrayIndexOutOfBoundsException", () -> { int[] values = {1}; int ignored = values[2]; });
        demonstrate("NumberFormatException", () -> Integer.parseInt("not-a-number"));
    }

    private static void demonstrate(String name, ThrowingAction action) {
        try { action.run(); } catch (Exception exception) { System.out.println(name + ": " + exception.getMessage()); }
    }

    private interface ThrowingAction { void run() throws Exception; }
}
