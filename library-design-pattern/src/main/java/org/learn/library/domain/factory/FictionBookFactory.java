package org.learn.library.domain.factory;

import org.learn.library.domain.Book;
import org.learn.library.domain.enums.BookFormat;
import org.learn.library.domain.enums.BookStatus;
import org.learn.library.domain.enums.BookType;

public class FictionBookFactory extends BookFactory {
    @Override
    public Book createBook(String title, String author, BookFormat format) {
        return new Book(null, title, author, BookType.FICCION, format, BookStatus.DISPONIBLE);
    }
}
