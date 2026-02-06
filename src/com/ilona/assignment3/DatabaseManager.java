package com.ilona.assignment3;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<BorrowRecord> records = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public void borrowBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book != null && member != null && book.isAvailable()) {
            book.borrowBook();
            records.add(new BorrowRecord(bookId, memberId));
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Error: Book not available or member not found.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Error: Book not found or already available.");
        }
    }
}
