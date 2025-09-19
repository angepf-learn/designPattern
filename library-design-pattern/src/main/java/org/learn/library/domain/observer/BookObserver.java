package org.learn.library.domain.observer;

import org.learn.library.domain.Book;

public interface BookObserver {
    void onBookLent(Book book);
}
