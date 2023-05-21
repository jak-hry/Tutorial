package com.kodilla.sudoku;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SudokuGame {
    protected final SudokuSolver solver;
    private CommandDescriptions commandDescriptions;
    private CommandHandler commandHandler;
    private Scanner scanner;
    private Settings settings;
    private Statistics statistics;
    boolean isplayerMove = true;

    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        game.startMenu();
    }

    public SudokuGame() {
        solver = new SudokuSolver();
        commandDescriptions = new CommandDescriptions();
        commandHandler = new CommandHandler(this);
        scanner = new Scanner(System.in);
        settings = new Settings();
        statistics = new Statistics();
    }

    public void startGame() {
        solver.fillBoard();
        solver.removeNumbers(chooseDifficultyLevel());

        continueLoadedGame();
    }

    public void continueLoadedGame() {
        while (!solver.isBoardFull()) {
            displayBoard();
            enterNumber();
        }
        solver.restoreBoard();
        System.out.println("Congratulations! Sudoku puzzle solved.");
    }

    private void startMenu() {
        while (true) {
            try {
                System.out.println("\nWelcome to Sudoku, choose: \n");
                System.out.println("1 - New game");
                System.out.println("2 - Load Game");
                System.out.println("3 - Settings");
                System.out.println("4 - Statistics");
                System.out.println("5 - Useful Commands");
                System.out.println("\n9 - Quit\n");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        startGame();
                        break;
                    case 2:
                        commandHandler.loadGameMenu();
                        break;
                    case 3:
                        settings.showSettingsMenu();
                        break;
                    case 4:
                        statistics.showStatistics();
                        break;
                    case 5:
                        commandDescriptions.displayCommandInfo();
                        break;
                    case 9:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private DifficultyLevel chooseDifficultyLevel() {
        DifficultyLevel difficultyLevel = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("\nChoose the difficulty level\n");
                System.out.println("1 - Easy");
                System.out.println("2 - Medium");
                System.out.println("3 - Hard");
                System.out.println("4 - Expert");
                System.out.println("5 - Highest\n");
                int choose = scanner.nextInt();

                switch (choose) {
                    case 1 -> {
                        difficultyLevel = DifficultyLevel.EASY;
                        validInput = true;
                    }
                    case 2 -> {
                        difficultyLevel = DifficultyLevel.MEDIUM;
                        validInput = true;
                    }
                    case 3 -> {
                        difficultyLevel = DifficultyLevel.HARD;
                        validInput = true;
                    }
                    case 4 -> {
                        difficultyLevel = DifficultyLevel.EXPERT;
                        validInput = true;
                    }
                    case 5 -> {
                        difficultyLevel = DifficultyLevel.HIGHEST;
                        validInput = true;
                    }
                    default -> System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        return difficultyLevel;
    }

    private void enterNumber() {
        isplayerMove = false;
        while (true) {
            try {
                System.out.print("\nEnter row (1-9): ");
                String rowInput = scanner.next();
                if (commandHandler.checkPause(rowInput)) break;
                commandHandler.checkGameEnd(rowInput);
                commandHandler.checkSaveGame(rowInput);
                int row = Integer.parseInt(rowInput) - 1;

                System.out.print("Enter column (1-9): ");
                String colInput = scanner.next();
                if (commandHandler.checkPause(colInput)) break;
                commandHandler.checkGameEnd(rowInput);
                commandHandler.checkSaveGame(rowInput);
                int col = Integer.parseInt(colInput) - 1;

                System.out.print("Enter number (1-9): ");
                String numInput = scanner.next();
                if (commandHandler.checkPause(numInput)) break;
                commandHandler.checkGameEnd(rowInput);
                commandHandler.checkSaveGame(rowInput);
                int num = Integer.parseInt(numInput);

                if (row < 0 || row > 8 || col < 0 || col > 8) {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                if (num < 1 || num > 9) {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    continue;
                }

                solver.enterNumber(row, col, num, isplayerMove);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public void displayBoard() {
        String numberColor = ColorPreferences.getColorSelection(Settings.NUMBER_COLOR_PROPERTIES).getDisplayName();
        String borderColor = ColorPreferences.getColorSelection(Settings.BOARD_BORDER_COLOR_PROPERTIES).getDisplayName();
        int[][] board = solver.getBoard();
        boolean[][] generatedNumbers = solver.getGeneratedNumbers();
        System.out.format("%s%n", borderColor + "|-------+-------+-------|" + borderColor);

        for (int i = 0; i < board.length; i++) {
            if (i > 0 && i % 3 == 0) {
                System.out.format("%s", borderColor + "|-------+-------+-------|" + borderColor);
                System.out.println();
            }
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0 || j % 3 == 0) {
                    System.out.format("%s", borderColor + "| ");
                }
                int num = board[i][j];
                boolean isGenerated = generatedNumbers[i][j];

                String displayNum;
                if (num == 0) {
                    displayNum = " ";
                } else {
                    if (isGenerated) {
                        displayNum = numberColor + num + borderColor;
                    } else {
                        displayNum = Color.DEFAULT.getDisplayName() + num + borderColor;
                    }
                }

                System.out.print(displayNum + " ");
            }
            System.out.format("%s%n", borderColor + "|");
        }
        System.out.format("%s%n", borderColor + "|-------+-------+-------|" + Color.DEFAULT.getDisplayName());
    }
}