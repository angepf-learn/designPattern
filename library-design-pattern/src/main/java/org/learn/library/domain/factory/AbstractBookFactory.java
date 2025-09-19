package org.learn.library.domain.factory;

import org.learn.library.domain.Book;
import org.learn.library.domain.enums.BookType;

public interface AbstractBookFactory {
    Book createFictionBook(String title, String author);
    Book createNonFictionBook(String title, String author);
}
