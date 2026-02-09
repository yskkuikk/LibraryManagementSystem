package com.ilona.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<BorrowRecord> records = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        Member librarian = new Member(1, "Admin", "admin@mail.com", "Librarian");
        Member memberUser = new Member(2, "Ilona", "john@mail.com", "Member");

        members.add(librarian);
        members.add(memberUser);

        System.out.println("Welcome to Library Management System");
        System.out.print("Enter username: ");
        String inputName = scanner.nextLine();
        Member currentUser = null;

        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(inputName)) {
                currentUser = m;
                break;
            }
        }

        if (currentUser == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Logged in as: " + currentUser.getRole());

        if (currentUser.getRole().equalsIgnoreCase("Librarian")) {
            librarianMenu(currentUser);
        } else {
            memberMenu(currentUser);
        }
    }

    private void librarianMenu(Member currentUser) {
        while (true) {
            System.out.println("\n--- Librarian Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    addMember();
                    break;
                case 4:
                    borrowBook(currentUser);
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    return;
            }
        }
    }

    private void memberMenu(Member currentUser) {
        while (true) {
            System.out.println("\n--- Member Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    borrowBook(currentUser);
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added.");
    }

    private void viewBooks() {
        for (Book b : books) b.display();
    }

    private void addMember() {
        System.out.print("Enter member ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter role (Member/Librarian): ");
        String role = scanner.nextLine();
        members.add(new Member(id, name, contact, role));
        System.out.println("Member added.");
    }

    private void borrowBook(Member currentUser) {
        System.out.print("Enter book ID to borrow: ");
        int bid = Integer.parseInt(scanner.nextLine());
        Book borrowBook = null;
        for (Book b : books) if (b.getId() == bid) borrowBook = b;
        if (borrowBook == null || !borrowBook.isAvailable()) {
            System.out.println("Book not available.");
        } else {
            records.add(new BorrowRecord(currentUser, borrowBook));
            borrowBook.borrow();
            System.out.println("Book borrowed.");
        }
    }

    private void returnBook() {
        System.out.print("Enter book ID to return: ");
        int rid = Integer.parseInt(scanner.nextLine());
        BorrowRecord recordToReturn = null;
        for (BorrowRecord r : records) {
            if (r.getBook().getId() == rid && r.getReturnDate() == null) {
                recordToReturn = r;
                break;
            }
        }
        if (recordToReturn != null) {
            recordToReturn.returnBook();
            System.out.println("Book returned.");
        } else {
            System.out.println("Borrow record not found.");
        }
    }
}
