package ass5.q5;

import java.util.Objects;

class GenericUtility {
    static <T> boolean isEqual(T first, T second) { return Objects.equals(first, second); }
    static <T> T getDefault(T value, T defaultValue) { return value != null ? value : defaultValue; }
    static <T extends Comparable<T>> T max(T first, T second) { return first.compareTo(second) >= 0 ? first : second; }
    static <T> boolean isNull(T value) { return Objects.isNull(value); }
}

public class Main {
    public static void main(String[] args) { System.out.println(GenericUtility.isEqual("Java", "Java")); System.out.println(GenericUtility.getDefault(null, "Fallback")); System.out.println(GenericUtility.max(10, 20)); System.out.println(GenericUtility.isNull(null)); }
}
