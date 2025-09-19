package org.learn.library.domain.validation;

import org.learn.library.domain.Book;

public abstract class BookValidator {
    protected BookValidator next;

    public BookValidator linkWith(BookValidator next) {
        this.next = next;
        return next;
    }

    public abstract void validate(Book book);

    protected void validateNext(Book book) {
        if (next != null) {
            next.validate(book);
        }
    }
}
