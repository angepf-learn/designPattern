package org.learn.library.application.impl;

import org.learn.library.domain.decorator.BookComponent;
import org.learn.library.domain.decorator.BookConcreteComponent;
import org.learn.library.domain.decorator.LendingBookDecorator;
import org.learn.library.domain.builder.BookBuilder;

import org.learn.library.domain.enums.BookFormat;
import org.learn.library.domain.factory.AbstractBookFactory;
import org.learn.library.domain.factory.PhysicalBookFactory;
import org.learn.library.domain.factory.DigitalBookFactory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.learn.library.application.IBookService;
import org.learn.library.domain.Book;
import org.learn.library.domain.enums.BookType;

import org.learn.library.domain.observer.BookSubject;
import org.learn.library.domain.observer.LendingNotificationObserver;
import org.learn.library.domain.search.BookSearchStrategy;
import org.learn.library.domain.search.SearchByAuthorStrategy;
import org.learn.library.domain.search.SearchByTitleStrategy;
import org.learn.library.domain.validation.BookValidator;
import org.learn.library.domain.validation.TitleValidator;
import org.learn.library.domain.validation.AuthorValidator;
import org.learn.library.infrastructure.BookRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final BookSubject bookSubject = new BookSubject();

    {
        bookSubject.addObserver(new LendingNotificationObserver());
    }

    @Override
    public Flux<Book> search(String query, String by) {
        BookSearchStrategy strategy;
        if (by.equalsIgnoreCase("title")) {
            strategy = new SearchByTitleStrategy(bookRepository);
        } else if (by.equalsIgnoreCase("author")) {
            strategy = new SearchByAuthorStrategy(bookRepository);
        } else {
            strategy = new SearchByTitleStrategy(bookRepository);
        }
        return strategy.search(query);
    }

    public Mono<Book> save(Book book) {
        validateBook(book);
        // Selección de Abstract Factory según el formato
        AbstractBookFactory factory;
        if (book.getFormat() == BookFormat.FISICO) {
            factory = new PhysicalBookFactory();
        } else {
            factory = new DigitalBookFactory();
        }
        Book bookToSave;
        if (book.getType() == BookType.FICCION) {
            Book fiction = factory.createFictionBook(book.getTitle(), book.getAuthor());
            bookToSave = new BookBuilder()
                .title(fiction.getTitle())
                .author(fiction.getAuthor())
                .type(fiction.getType())
                .format(fiction.getFormat())
                .status(fiction.getStatus())
                .build();
        } else {
            Book nonFiction = factory.createNonFictionBook(book.getTitle(), book.getAuthor());
            bookToSave = new BookBuilder()
                .title(nonFiction.getTitle())
                .author(nonFiction.getAuthor())
                .type(nonFiction.getType())
                .format(nonFiction.getFormat())
                .status(nonFiction.getStatus())
                .build();
        }
        return bookRepository.save(bookToSave);
    }

    private void validateBook(Book book) {
        BookValidator titleValidator = new TitleValidator();
        BookValidator authorValidator = new AuthorValidator();
        titleValidator.linkWith(authorValidator);
        titleValidator.validate(book);
    }

    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    public Mono<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return bookRepository.deleteById(id);
    }

    public Mono<Book> lendBookWithDecorator(Long id) {
        return bookRepository.findById(id)
                .flatMap(book -> {
                    BookComponent bookComponent = new BookConcreteComponent(book);
                    BookComponent lendingDecorator = new LendingBookDecorator(bookComponent);
                    try {
                        lendingDecorator.lend();
                    } catch (Exception e) {
                        return Mono.error(e);
                    }

                    return bookRepository.save(book)
                            .doOnSuccess(savedBook -> bookSubject.notifyBookLent(savedBook));
                });
    }

}
