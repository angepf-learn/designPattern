package org.learn.library.domain.validation;

import org.learn.library.domain.Book;

public class AuthorValidator extends BookValidator {
    @Override
    public void validate(Book book) {
        if (book.getAuthor() == null || book.getAuthor().trim().length() < 3) {
            throw new IllegalArgumentException("El autor debe ser válido y tener al menos 3 caracteres");
        }
        validateNext(book);
    }
}
