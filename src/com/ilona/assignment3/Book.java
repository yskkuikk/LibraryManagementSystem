package com.ilona.assignment3;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void borrow() {
        if(isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Book not available");
        }
    }

    public void returned() {
        isAvailable = true;
    }

    public void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
}
