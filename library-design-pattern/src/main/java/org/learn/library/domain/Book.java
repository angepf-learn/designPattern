package org.learn.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.learn.library.domain.enums.BookFormat;
import org.learn.library.domain.enums.BookStatus;
import org.learn.library.domain.enums.BookType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    private Long id;
    private String title;
    private String author;
    private BookType type;
    private BookFormat format;
    private BookStatus status;

}
