package com.ilona.assignment3;

public class Book {

    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean value) {
        this.available = value;
    }

    public String toString() {
        return "ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Available: " + available;
    }
}
