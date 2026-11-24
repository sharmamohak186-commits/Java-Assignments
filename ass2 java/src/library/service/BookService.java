package library.service;

import library.model.Book;

public class BookService implements Printable {
    private final Book book;

    public BookService(Book book) {
        this.book = book;
    }

    @Override
    public void printDetails() {
        System.out.println("Book: " + book.details());
    }
}
