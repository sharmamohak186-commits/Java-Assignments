package library.model;

import library.service.Printable;

public class Book extends LibraryResource implements Printable {
    public Book(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return Math.max(0, overdueDays) * 5.0;
    }

    @Override
    public void printDetails() {
        System.out.println("Book: " + details());
    }
}
