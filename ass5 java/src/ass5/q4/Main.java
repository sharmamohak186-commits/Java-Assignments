package ass5.q4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Event name: "); String name = scanner.nextLine();
        LocalDate eventDate = LocalDate.now().plusDays(2); LocalTime start = LocalTime.of(10, 0);
        LocalDateTime startTime = LocalDateTime.of(eventDate, start);
        LocalDateTime endTime = startTime.plusHours(2);
        System.out.println("Event: " + name + " | " + startTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        System.out.println("Status: " + (eventDate.isAfter(LocalDate.now()) ? "future" : eventDate.equals(LocalDate.now()) ? "today" : "past"));
        System.out.println("Days remaining: " + (Duration.between(LocalDateTime.now(), startTime).toHours() / 24));
        System.out.println("Ends: " + endTime.toLocalTime());
        Optional<String> optionalName = Optional.ofNullable(name.trim().isEmpty() ? null : name.trim());
        System.out.println(optionalName.orElse("Venue not specified"));
        scanner.close();
    }
}
