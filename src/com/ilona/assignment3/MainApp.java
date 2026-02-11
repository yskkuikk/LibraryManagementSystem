package com.ilona.assignment3;

import java.util.Scanner;

public class MainApp {

    Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1 - Admin");
            System.out.println("2 - Member");
            System.out.println("3 - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                adminLogin();
            } else if (choice == 2) {
                memberMenu();
            } else {
                break;
            }
        }
    }

    private void adminLogin() {

        System.out.println("Enter admin password:");
        String pass = scanner.nextLine();

        if (!pass.equals("676767")) {
            System.out.println("Wrong password.");
            return;
        }

        while (true) {

            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1 - Add Book");
            System.out.println("2 - View Books");
            System.out.println("3 - View Members");
            System.out.println("4 - View Borrow Records");
            System.out.println("5 - Back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addBook();
            } else if (choice == 2) {
                viewBooks();
            } else if (choice == 3) {
                viewMembers();
            } else if (choice == 4) {
                viewRecords();
            } else {
                break;
            }
        }
    }

    private void memberMenu() {

        System.out.println("\n1 - Register");
        System.out.println("2 - Login");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            registerMember();
        } else {
            loginMember();
        }
    }

    private void registerMember() {

        System.out.println("Enter ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (DatabaseManager.findMember(id) != null) {
            System.out.println("Member with this ID already exists.");
            return;
        }

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        Member m = new Member(id, name, password);
        DatabaseManager.addMember(m);

        System.out.println("Registration successful.");
    }

    private void loginMember() {

        System.out.println("Enter ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Password:");
        String pass = scanner.nextLine();

        Member m = DatabaseManager.findMember(id);

        if (m == null || !m.getPassword().equals(pass)) {
            System.out.println("Invalid login.");
            return;
        }

        while (true) {

            System.out.println("\n--- MEMBER MENU ---");
            System.out.println("1 - View Books");
            System.out.println("2 - Borrow Book");
            System.out.println("3 - Return Book");
            System.out.println("4 - Back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                viewBooks();
            } else if (choice == 2) {
                borrowBook(m);
            } else if (choice == 3) {
                returnBook(m);
            } else {
                break;
            }
        }
    }

    private void addBook() {

        System.out.println("Enter Book ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (DatabaseManager.findBook(id) != null) {
            System.out.println("Book with this ID already exists.");
            return;
        }

        System.out.println("Enter Title:");
        String title = scanner.nextLine();

        System.out.println("Enter Author:");
        String author = scanner.nextLine();

        Book b = new Book(id, title, author);
        DatabaseManager.addBook(b);

        System.out.println("Book added successfully.");
    }

    private void viewBooks() {
        for (Book b : DatabaseManager.books) {
            System.out.println(b);
        }
    }

    private void viewMembers() {
        for (Member m : DatabaseManager.members) {
            System.out.println(m);
        }
    }

    private void viewRecords() {
        for (BorrowRecord r : DatabaseManager.records) {
            System.out.println(r);
        }
    }

    private void borrowBook(Member m) {

        System.out.println("Enter Book ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book b = DatabaseManager.findBook(id);

        if (b == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!b.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        b.setAvailable(false);
        DatabaseManager.records.add(new BorrowRecord(m, b));

        System.out.println("Book borrowed successfully.");
    }

    private void returnBook(Member m) {

        System.out.println("Enter Book ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book b = DatabaseManager.findBook(id);

        if (b == null) {
            System.out.println("Book not found.");
            return;
        }

        b.setAvailable(true);

        System.out.println("Book returned successfully.");
    }
}
