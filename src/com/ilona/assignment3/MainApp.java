package com.ilona.assignment3;

import java.util.Scanner;

public class MainApp {

    private DatabaseManager db = new DatabaseManager();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> addMember();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addBook() {
        System.out.print("Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();

        db.addBook(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    private void viewBooks() {
        for (Book book : db.getBooks()) {
            System.out.println(book);
        }
    }

    private void addMember() {
        System.out.print("Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();

        db.addMember(new Member(id, name));
        System.out.println("Member added successfully.");
    }

    private void borrowBook() {
        System.out.print("Book ID: ");
        int bookId = scanner.nextInt();
        System.out.print("Member ID: ");
        int memberId = scanner.nextInt();

        db.borrowBook(bookId, memberId);
    }

    private void returnBook() {
        System.out.print("Book ID: ");
        int bookId = scanner.nextInt();

        db.returnBook(bookId);
    }
}
