package org.learn.library.domain.adapter;

import org.learn.library.domain.enums.BookType;
import org.learn.library.domain.enums.BookFormat;
import org.learn.library.domain.enums.BookStatus;

public class LegacyBookAdapter implements IBook {
    private final LegacyBook legacyBook;

    public LegacyBookAdapter(LegacyBook legacyBook) {
        this.legacyBook = legacyBook;
    }

    @Override
    public String getTitle() {
        return legacyBook.getName();
    }

    @Override
    public String getAuthor() {
        return legacyBook.getWriter();
    }

    @Override
    public BookType getType() {
        return "fiction".equalsIgnoreCase(legacyBook.getCategory()) ? BookType.FICCION : BookType.NO_FICCION;
    }

    @Override
    public BookFormat getFormat() {
        return "physical".equalsIgnoreCase(legacyBook.getFormatLegacy()) ? BookFormat.FISICO : BookFormat.DIGITAL;
    }

    @Override
    public BookStatus getStatus() {
        return "available".equalsIgnoreCase(legacyBook.getStateLegacy()) ? BookStatus.DISPONIBLE : BookStatus.PRESTADO;
    }
}
