package ass5.q2;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("student@example.com");
        Optional<String> empty = Optional.empty();
        System.out.println("Email: " + email.get());
        System.out.println("Present: " + email.isPresent());
        email.ifPresent(value -> System.out.println("Verified email: " + value));
        System.out.println("Default: " + empty.orElse("default@example.com"));
        try {
            System.out.println("Fallback: " + empty.orElseThrow(() -> new IllegalArgumentException("Email is missing")));
        } catch (IllegalArgumentException exception) {
            System.out.println("Handled missing email: " + exception.getMessage());
        }
    }
}
