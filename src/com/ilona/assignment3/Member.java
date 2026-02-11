package com.ilona.assignment3;

public class Member {

    private int id;
    private String name;
    private String password;

    public Member(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "Member ID: " + id + " | Name: " + name;
    }
}
