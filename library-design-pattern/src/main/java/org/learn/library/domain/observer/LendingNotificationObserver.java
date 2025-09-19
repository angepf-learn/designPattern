package org.learn.library.domain.observer;

import org.learn.library.domain.Book;

public class LendingNotificationObserver implements BookObserver {
    @Override
    public void onBookLent(Book book) {
        // Aquí podrías enviar un email, log, etc. Por ahora solo imprime
        System.out.println("Notificación: El libro '" + book.getTitle() + "' ha sido prestado.");
    }
}
