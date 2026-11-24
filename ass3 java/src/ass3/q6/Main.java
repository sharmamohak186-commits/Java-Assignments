package ass3.q6;

class InvalidUsernameException extends Exception { InvalidUsernameException(String message) { super(message); } }
class InvalidPasswordException extends Exception { InvalidPasswordException(String message) { super(message); } }
class AccountLockedException extends Exception { AccountLockedException(String message) { super(message); } }

public class Main {
    private static final String USERNAME = "student";
    private static final String PASSWORD = "Java@123";
    private static int failedAttempts;

    public static void main(String[] args) {
        String[][] attempts = {{"wrong", "bad"}, {"student", "bad"}, {"student", "Java@123"}};
        for (String[] attempt : attempts) {
            try { login(attempt[0], attempt[1]); System.out.println("Login successful."); }
            catch (AccountLockedException | InvalidUsernameException | InvalidPasswordException exception) { System.out.println(exception.getMessage()); }
        }
    }

    private static void login(String username, String password) throws InvalidUsernameException, InvalidPasswordException, AccountLockedException {
        if (failedAttempts >= 3) throw new AccountLockedException("Account locked after three failed attempts.");
        try {
            if (!USERNAME.equals(username)) throw new InvalidUsernameException("Invalid username.");
            if (!PASSWORD.equals(password)) throw new InvalidPasswordException("Invalid password.");
        } catch (InvalidUsernameException | InvalidPasswordException exception) { failedAttempts++; throw exception; }
    }
}
