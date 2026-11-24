package q1;

public class RegularOrder extends FoodOrder {
    public RegularOrder(int orderId, String customerName, double orderAmount) {
        super(orderId, customerName, orderAmount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return 80.0;
    }
}
