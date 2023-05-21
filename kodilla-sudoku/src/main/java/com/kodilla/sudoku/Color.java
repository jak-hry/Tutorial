package com.kodilla.sudoku;

public enum Color {
    DEFAULT("\u001B[0m"),
    WHITE("\u001B[37m"),
    TAN("\u001B[38;5;180m"),
    GOLD("\u001B[38;5;220m"),
    BROWN("\u001B[38;5;130m"),
    RUST("\u001B[38;5;166m"),
    CORAL("\u001B[38;5;209m"),
    ORANGE("\u001B[33m"),
    OLIVE("\u001B[38;5;100m"),
    GREEN("\u001B[32m"),
    CYAN("\u001B[36m"),
    AZURE("\u001B[38;5;45m"),
    TEAL("\u001B[38;5;51m"),
    PURPLE("\u001B[35m"),
    RED("\u001B[31m"),
    RUBY("\u001B[38;5;124m");


    private String displayName;

    Color(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}