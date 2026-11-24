package ass5.q3;

import java.util.Objects;

class Result<T extends Number> {
    private final T[] marks;
    Result(T[] marks) { this.marks = Objects.requireNonNull(marks, "Marks cannot be null"); }
    double percentage() { double total = 0; for (T mark : marks) total += Objects.requireNonNull(mark).doubleValue(); return total / marks.length; }
    boolean passed(double threshold) { return percentage() >= threshold; }
}

public class Main {
    public static void main(String[] args) { Result<Integer> result = new Result<>(new Integer[]{78, 84, 91, 73, 88}); System.out.printf("Percentage: %.2f%%%nPassed: %s%n", result.percentage(), result.passed(40)); }
}
