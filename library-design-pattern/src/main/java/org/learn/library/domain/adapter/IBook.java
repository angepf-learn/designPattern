package org.learn.library.domain.adapter;

import org.learn.library.domain.enums.BookType;
import org.learn.library.domain.enums.BookFormat;
import org.learn.library.domain.enums.BookStatus;

public interface IBook {
    String getTitle();
    String getAuthor();
    BookType getType();
    BookFormat getFormat();
    BookStatus getStatus();
}
