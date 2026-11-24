package library.utility;

public final class InputValidator {
    private InputValidator() {
    }

    public static boolean isValidResourceId(int resourceId) {
        return resourceId > 0;
    }

    public static boolean isValidOverdueDays(int overdueDays) {
        return overdueDays >= 0;
    }
}
