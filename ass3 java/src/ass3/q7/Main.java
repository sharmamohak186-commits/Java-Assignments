package ass3.q7;

class ApplicationException extends Exception { ApplicationException(String message) { super(message); } }
class ProductException extends ApplicationException { ProductException(String message) { super(message); } }
class ProductNotFoundException extends ProductException { ProductNotFoundException(String message) { super(message); } }
class OutOfStockException extends ProductException { OutOfStockException(String message) { super(message); } }
class PaymentException extends ApplicationException { PaymentException(String message) { super(message); } }
class InvalidPaymentException extends PaymentException { InvalidPaymentException(String message) { super(message); } }
class InsufficientFundsException extends PaymentException { InsufficientFundsException(String message) { super(message); } }
class OrderException extends ApplicationException { OrderException(String message) { super(message); } }
class EmptyCartException extends OrderException { EmptyCartException(String message) { super(message); } }

public class Main {
    public static void main(String[] args) {
        try { addProduct("P100", 2); pay(0); placeOrder(false); }
        catch (ApplicationException exception) { System.out.println("Application error: " + exception.getMessage()); }
        try { placeOrder(true); } catch (ApplicationException exception) { System.out.println("Order error: " + exception.getMessage()); }
    }
    private static void addProduct(String code, int stock) throws ProductException { if (stock <= 0) throw new OutOfStockException(code + " is out of stock."); System.out.println("Added product " + code); }
    private static void pay(double amount) throws PaymentException { if (amount <= 0) throw new InvalidPaymentException("Payment must be greater than zero."); if (amount < 100) throw new InsufficientFundsException("Insufficient funds."); }
    private static void placeOrder(boolean cartHasItems) throws OrderException { if (!cartHasItems) throw new EmptyCartException("Cannot place an empty cart."); }
}
