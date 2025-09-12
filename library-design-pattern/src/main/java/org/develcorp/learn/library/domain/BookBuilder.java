package org.develcorp.learn.library.domain;

public class BookBuilder {

    private Long id;
    private String title;
    private String author;
    private BookType type;
    private BookFormat format;
    private BookStatus status;

    public BookBuilder id(Long id) { this.id = id; return this; }
    public BookBuilder title(String title) { this.title = title; return this; }
    public BookBuilder author(String author) { this.author = author; return this; }
    public BookBuilder type(BookType type) { this.type = type; return this; }
    public BookBuilder format(BookFormat format) { this.format = format; return this; }
    public BookBuilder status(BookStatus status) { this.status = status; return this; }
    public Book build() { return new Book(/*...*/); }
}
