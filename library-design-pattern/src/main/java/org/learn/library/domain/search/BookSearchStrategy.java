package org.learn.library.domain.search;

import org.learn.library.domain.Book;
import reactor.core.publisher.Flux;

public interface BookSearchStrategy {
    Flux<Book> search(String query);
}
