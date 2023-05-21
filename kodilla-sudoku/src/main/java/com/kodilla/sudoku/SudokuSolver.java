package com.kodilla.sudoku;

import java.util.Random;

public class SudokuSolver {
    int[][] board;
    private int[][] savedBoard;
    private boolean[][] fixedCells;
    private int[][] solution;
    private boolean[][] generatedNumbers;
    private Random random;

    public SudokuSolver() {
        board = new int[9][9];
        savedBoard = new int[9][9];
        fixedCells = new boolean[9][9];
        solution = new int[9][9];
        random = new Random();
        generatedNumbers = new boolean[9][9];
    }
    public int[][] fillBoard() {
        clearBoard();
        solveBoard();
        solution = copyBoard(board);
        generatedNumbers = generateGeneratedNumbers();
        return solution;
    }

    private boolean[][] generateGeneratedNumbers() {
        boolean[][] generated = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                generated[row][col] = !fixedCells[row][col];
            }
        }
        return generated;
    }

    public void removeNumbers(DifficultyLevel difficultyLevel) {
        int cellsToRemove = 0;
        switch (difficultyLevel) {
            case EASY -> cellsToRemove = 30;
            case MEDIUM -> cellsToRemove = 40;
            case HARD -> cellsToRemove = 50;
            case EXPERT -> cellsToRemove = 60;
            case HIGHEST -> cellsToRemove = 70;
        }
        while (cellsToRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);

            if (board[row][col] != 0 && !fixedCells[row][col]) {
                board[row][col] = 0;
                cellsToRemove--;
            }
        }
    }

    private void clearBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = 0;
                fixedCells[row][col] = false;
            }
        }
    }

    public void enterNumber(int row, int col, int num, boolean isPlayerMove) {
        board[row][col] = num;
        generatedNumbers[row][col] = isPlayerMove;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] copyBoard(int[][] source) {
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy[i][j] = source[i][j];
            }
        }
        return copy;
    }

    private void solveBoard() {
        solveBoard(0, 0);
    }

    public void restoreBoard() {
        board = copyBoard(savedBoard);
    }

    private boolean solveBoard(int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }

        if (board[row][col] != 0) {
            return solveBoard(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValidMove(row, col, num)) {
                board[row][col] = num;
                if (solveBoard(row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    public boolean isValidMove(int row, int col, int num) {
        if (num == 0) {
            return false;
        } else if (isInRow(row, num) || isInColumn(col, num) || isInBox(row, col, num)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isInRow(int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isInColumn(int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean isInBox(int row, int col, int num) {
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;

        for (int r = boxStartRow; r < boxStartRow + 3; r++) {
            for (int c = boxStartCol; c < boxStartCol + 3; c++) {
                if (board[r][c] == num) {
                    return true;
                }
            }
        }

        return false;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean[][] getGeneratedNumbers() {
        return generatedNumbers;
    }

    public int[][] getSolution() {
        return solution;
    }

    public void setGeneratedNumbers(boolean[][] generatedNumbers) {
        this.generatedNumbers = generatedNumbers;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}