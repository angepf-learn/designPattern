package org.learn.library.domain.factory;

import org.learn.library.domain.Book;
import org.learn.library.domain.enums.BookFormat;
import org.learn.library.domain.enums.BookStatus;
import org.learn.library.domain.enums.BookType;

public abstract class BookFactory {
    public abstract Book createBook(String title, String author, BookFormat format);
}
