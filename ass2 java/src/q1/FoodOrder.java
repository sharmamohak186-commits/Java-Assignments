package q1;

public abstract class FoodOrder {
    private final int orderId;
    private final String customerName;
    private final double orderAmount;
    private static int orderCount;

    protected FoodOrder(int orderId, String customerName, double orderAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
        orderCount++;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public abstract double calculateDeliveryCharge();

    public double getDiscount() {
        return orderAmount >= 1000 ? orderAmount * 0.10 : 0.0;
    }

    public double getFinalPayableAmount() {
        return orderAmount - getDiscount() + calculateDeliveryCharge();
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public static void displayTotalOrders() {
        System.out.println("Total orders created: " + orderCount);
    }

    public String summary() {
        return String.format("Order %d | Customer: %s | Amount: Rs. %.2f | Discount: Rs. %.2f | Delivery: Rs. %.2f | Payable: Rs. %.2f",
                orderId, customerName, orderAmount, getDiscount(), calculateDeliveryCharge(), getFinalPayableAmount());
    }
}
