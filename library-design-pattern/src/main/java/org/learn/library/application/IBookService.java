package org.learn.library.application;

import org.learn.library.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBookService {
    Mono<Book> save(Book book);
    Flux<Book> findAll();
    Mono<Book> findById(Long id);
    Mono<Void> deleteById(Long id);
    Flux<Book> search(String query, String by);
    Mono<Book> lendBookWithDecorator(Long id);
}