package org.learn.library.domain.factory;

import org.learn.library.domain.Book;
import org.learn.library.domain.enums.BookFormat;
import org.learn.library.domain.enums.BookStatus;
import org.learn.library.domain.enums.BookType;

public class DigitalBookFactory implements AbstractBookFactory {
    @Override
    public Book createFictionBook(String title, String author) {
        return new Book(null, title, author, BookType.FICCION, BookFormat.DIGITAL, BookStatus.DISPONIBLE);
    }
    @Override
    public Book createNonFictionBook(String title, String author) {
        return new Book(null, title, author, BookType.NO_FICCION, BookFormat.DIGITAL, BookStatus.DISPONIBLE);
    }
}
