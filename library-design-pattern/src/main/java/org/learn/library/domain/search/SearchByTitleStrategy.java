package org.learn.library.domain.search;

import org.learn.library.domain.Book;
import org.learn.library.infrastructure.BookRepository;
import reactor.core.publisher.Flux;

public class SearchByTitleStrategy implements BookSearchStrategy {
    private final BookRepository bookRepository;

    public SearchByTitleStrategy(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Flux<Book> search(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
