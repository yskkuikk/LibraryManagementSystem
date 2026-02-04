package com.ilona.assignment3;

import java.time.LocalDate;

public class BorrowRecord {
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(int bookId, int memberId, LocalDate borrowDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }
}

