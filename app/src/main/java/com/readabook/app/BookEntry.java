package com.readabook.app;

public class BookEntry {
    public final int id;
    public final String title, author, category, status;
    public final int rating;

    public BookEntry(int id, String title, String author, String category, String status, int rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = status;
        this.rating = rating;
    }
}
