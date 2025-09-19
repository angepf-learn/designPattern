package org.learn.library.domain.decorator;

import org.learn.library.domain.enums.BookStatus;

public class LendingBookDecorator implements BookComponent {
    private final BookComponent bookComponent;
    public LendingBookDecorator(BookComponent bookComponent) {
        this.bookComponent = bookComponent;
    }
    @Override
    public BookStatus getStatus() {
        return bookComponent.getStatus();
    }
    @Override
    public void lend() {
        if (bookComponent.getStatus() == BookStatus.PRESTADO) {
            throw new IllegalStateException("El libro ya está prestado");
        }
        bookComponent.lend();
        // Aquí podrías notificar, loguear, etc.
        System.out.println("[DECORATOR] Libro prestado: " + bookComponent.getTitle());
    }
    @Override
    public String getTitle() {
        return bookComponent.getTitle();
    }
    // Otros métodos delegados
}
