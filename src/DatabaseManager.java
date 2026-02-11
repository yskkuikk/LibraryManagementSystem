package com.ilona.assignment3;

import java.util.ArrayList;

public class DatabaseManager {

    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Member> members = new ArrayList<>();
    public static ArrayList<BorrowRecord> records = new ArrayList<>();

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void addMember(Member member) {
        members.add(member);
    }

    public static Member findMember(int id) {
        for (Member m : members) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public static Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}
