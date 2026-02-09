package com.ilona.assignment3;

import java.util.Date;

public class BorrowRecord {
    private Member member;
    private Book book;
    private Date borrowDate;
    private Date returnDate;

    public BorrowRecord(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.borrowDate = new Date();
        this.returnDate = null;
    }

    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }

    public void returnBook() {
        this.returnDate = new Date();
        book.returned();
    }

    public void display() {
        System.out.println("Member: " + member.getName() +
                ", Book: " + book.getTitle() +
                ", Borrowed: " + borrowDate +
                ", Returned: " + (returnDate != null ? returnDate : "Not returned"));
    }
}
