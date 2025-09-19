package org.learn.library.domain.decorator;

import org.learn.library.domain.enums.BookStatus;

public interface BookComponent {
    BookStatus getStatus();
    void lend();
    String getTitle();
    // Otros métodos relevantes
}
