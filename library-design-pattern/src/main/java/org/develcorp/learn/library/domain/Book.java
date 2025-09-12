package org.develcorp.learn.library.domain;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private BookType type;
    private BookType format;
    private BookStatus status;

}
