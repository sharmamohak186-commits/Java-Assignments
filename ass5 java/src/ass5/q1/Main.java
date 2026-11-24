package ass5.q1;

public class Main {
    public static <T extends Number> double sum(T[] values) { double total = 0; for (T value : values) total += value.doubleValue(); return total; }
    public static void main(String[] args) { System.out.println("Integer sum: " + sum(new Integer[]{1, 2, 3, 4})); System.out.println("Double sum: " + sum(new Double[]{1.5, 2.5, 3.0})); }
}
