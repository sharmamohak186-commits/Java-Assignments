package library.model;

public abstract class LibraryResource {
    private final int resourceId;
    private final String title;
    private final String author;
    private static String libraryName = "Central Knowledge Library";

    protected LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    public static void setLibraryName(String name) {
        if (name != null && !name.trim().isEmpty()) libraryName = name.trim();
    }

    public abstract double calculateFine(int overdueDays);

    public String details() {
        return String.format("ID: %d | Title: %s | Author: %s", resourceId, title, author);
    }
}
