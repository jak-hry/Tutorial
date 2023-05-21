package com.kodilla.sudoku;

public enum DifficultyLevel {

    EASY("Easy_level"),
    MEDIUM("Medium_level"),
    HARD("Hard_level"),
    EXPERT("Expert_level"),
    HIGHEST("The_highest_level");
    private String displayName;

    DifficultyLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}