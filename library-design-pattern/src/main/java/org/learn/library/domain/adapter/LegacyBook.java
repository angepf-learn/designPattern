package org.learn.library.domain.adapter;

public class LegacyBook {
    private String name;
    private String writer;
    private String category;
    private String format;
    private String state;

    public LegacyBook(String name, String writer, String category, String format, String state) {
        this.name = name;
        this.writer = writer;
        this.category = category;
        this.format = format;
        this.state = state;
    }

    public String getName() { return name; }
    public String getWriter() { return writer; }
    public String getCategory() { return category; }
    public String getFormatLegacy() { return format; }
    public String getStateLegacy() { return state; }
}
