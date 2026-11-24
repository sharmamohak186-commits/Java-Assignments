package q1;

public class PremiumOrder extends FoodOrder {
    public PremiumOrder(int orderId, String customerName, double orderAmount) {
        super(orderId, customerName, orderAmount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return 50.0;
    }
}
