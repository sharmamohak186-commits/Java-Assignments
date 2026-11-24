package q1;

public final class OrderUtility {
    private OrderUtility() {
    }

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String customerName) {
        return customerName != null && !customerName.trim().isEmpty();
    }

    public static FoodOrder generateOrder(int orderId, String customerName, double amount, boolean premium) {
        if (!validateCustomerName(customerName)) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        if (!validateAmount(amount)) {
            throw new IllegalArgumentException("Order amount must be greater than zero.");
        }
        return premium
                ? new PremiumOrder(orderId, customerName.trim(), amount)
                : new RegularOrder(orderId, customerName.trim(), amount);
    }
}
