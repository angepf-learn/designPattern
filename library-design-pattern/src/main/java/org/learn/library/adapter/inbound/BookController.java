package org.learn.library.adapter.inbound;

import org.learn.library.domain.Book;
import org.learn.library.application.IBookService;
import org.learn.library.domain.adapter.LegacyBook;
import org.learn.library.domain.adapter.LegacyBookAdapter;
import org.learn.library.domain.adapter.IBook;
import org.learn.library.domain.builder.BookBuilder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
    
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PostMapping("/legacy")
    public Mono<Book> createLegacy(@RequestBody LegacyBook legacyBook) {
        IBook adapted = new LegacyBookAdapter(legacyBook);
        Book book = new BookBuilder()
                .title(adapted.getTitle())
                .author(adapted.getAuthor())
                .type(adapted.getType())
                .format(adapted.getFormat())
                .status(adapted.getStatus())
                .build();
        return bookService.save(book);
    }

    @PostMapping("/{id}/lend-decorator")
    public Mono<Book> lendBookWithDecorator(@PathVariable Long id) {
        return bookService.lendBookWithDecorator(id);
    }

    @GetMapping
    public Flux<Book> getAll(@RequestParam(value = "q", required = false) String query,
                             @RequestParam(value = "by", required = false, defaultValue = "all") String by) {
        if (query == null || query.isBlank() || by.equalsIgnoreCase("all")) {
            return bookService.findAll();
        }
        return bookService.search(query, by);
    }

    @GetMapping("/{id}")
    public Mono<Book> getById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return bookService.deleteById(id);
    }
}
