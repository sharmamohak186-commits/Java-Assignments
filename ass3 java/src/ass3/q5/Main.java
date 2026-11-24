package ass3.q5;

class InsufficientBalanceException extends Exception { InsufficientBalanceException(String message) { super(message); } }
class InvalidAmountException extends Exception { InvalidAmountException(String message) { super(message); } }
class AccountNotFoundException extends Exception { AccountNotFoundException(String message) { super(message); } }

class BankAccount {
    private final String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) { this.accountNumber = accountNumber; this.balance = balance; }
    void deposit(double amount) throws InvalidAmountException { if (amount <= 0) throw new InvalidAmountException("Deposit must be positive."); balance += amount; }
    void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal must be positive.");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance.");
        balance -= amount;
    }
    String getAccountNumber() { return accountNumber; }
    double getBalance() { return balance; }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("AC1001", 5000);
        try {
            account.deposit(1500);
            account.withdraw(2000);
            System.out.printf("Account %s balance: Rs. %.2f%n", account.getAccountNumber(), account.getBalance());
            account.withdraw(10000);
        } catch (Exception exception) { System.out.println("Transaction error: " + exception.getMessage()); }
        try { findAccount("AC9999"); } catch (AccountNotFoundException exception) { System.out.println("Lookup error: " + exception.getMessage()); }
    }

    private static BankAccount findAccount(String accountNumber) throws AccountNotFoundException {
        throw new AccountNotFoundException("Account " + accountNumber + " was not found.");
    }
}
