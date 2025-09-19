package org.learn.library.domain.decorator;

import org.learn.library.domain.Book;
import org.learn.library.domain.enums.BookStatus;

public class BookConcreteComponent implements BookComponent {
    private final Book book;
    public BookConcreteComponent(Book book) {
        this.book = book;
    }
    @Override
    public BookStatus getStatus() {
        return book.getStatus();
    }
    @Override
    public void lend() {
        book.setStatus(BookStatus.PRESTADO);
    }
    @Override
    public String getTitle() {
        return book.getTitle();
    }
    // Otros métodos delegados
}
