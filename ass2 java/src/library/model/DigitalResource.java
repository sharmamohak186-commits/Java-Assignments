package library.model;

import library.service.Printable;

public class DigitalResource extends LibraryResource implements Printable {
    public DigitalResource(int resourceId, String title, String author) {
        super(resourceId, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return Math.max(0, overdueDays) * 2.0;
    }

    @Override
    public void printDetails() {
        System.out.println("Digital resource: " + details());
    }
}
