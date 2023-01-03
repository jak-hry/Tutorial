package com.kodilla.good.patterns.allegro;

public class User {

    private final String userName;
    private final String surName;

    public User(String userName, String surName) {
        this.userName = userName;
        this.surName = surName;
    }

    public String getUserName() {
        return userName;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return userName + " " + surName;
    }
}
