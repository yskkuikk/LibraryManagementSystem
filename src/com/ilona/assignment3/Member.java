package com.ilona.assignment3;

public class Member {
    private int id;
    private String name;
    private String contactInfo;
    private String role;

    public Member(int id, String name, String contactInfo, String role) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Contact: " + contactInfo + ", Role: " + role);
    }
}
