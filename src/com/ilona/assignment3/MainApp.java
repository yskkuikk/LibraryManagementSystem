package com.ilona.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Library Management System ===");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Add Member");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                books.add(new Book(books.size() + 1, title, author, true));
                System.out.println("Book added.");
                break;

            case 2:
                for (Book book : books) {
                    System.out.println(book.getId() + ". " + book.getTitle() +
                            " by " + book.getAuthor() +
                            " | Available: " + book.isAvailable());
                }
                break;

            case 3:
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Contact info: ");
                String contact = scanner.nextLine();
                members.add(new Member(members.size() + 1, name, contact));
                System.out.println("Member added.");
                break;

            case 4:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}

