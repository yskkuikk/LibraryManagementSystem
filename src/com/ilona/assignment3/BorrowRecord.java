package com.ilona.assignment3;

public class BorrowRecord {

    private Member member;
    private Book book;

    public BorrowRecord(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public String toString() {
        return "Member ID: " + member.getId() +
                " borrowed Book ID: " + book.getId();
    }
}
