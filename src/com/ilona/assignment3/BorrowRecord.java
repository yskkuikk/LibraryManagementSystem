package com.ilona.assignment3;

import java.time.LocalDate;

public class BorrowRecord {
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;

    public BorrowRecord(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                ", Member ID: " + memberId +
                ", Borrowed on: " + borrowDate;
    }
}

