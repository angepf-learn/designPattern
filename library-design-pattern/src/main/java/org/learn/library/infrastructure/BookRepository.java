package org.learn.library.infrastructure;

import org.learn.library.domain.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
	reactor.core.publisher.Flux<Book> findByTitleContainingIgnoreCase(String title);
	reactor.core.publisher.Flux<Book> findByAuthorContainingIgnoreCase(String author);
}
