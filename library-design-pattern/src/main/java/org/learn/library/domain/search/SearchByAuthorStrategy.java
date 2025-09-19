package org.learn.library.domain.search;

import org.learn.library.domain.Book;
import org.learn.library.infrastructure.BookRepository;
import reactor.core.publisher.Flux;

public class    SearchByAuthorStrategy implements BookSearchStrategy {
    private final BookRepository bookRepository;

    public SearchByAuthorStrategy(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Flux<Book> search(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
}
