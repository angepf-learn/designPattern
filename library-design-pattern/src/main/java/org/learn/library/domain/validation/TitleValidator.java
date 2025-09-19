package org.learn.library.domain.validation;

import org.learn.library.domain.Book;

public class TitleValidator extends BookValidator {
    @Override
    public void validate(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        validateNext(book);
    }
}
