package com.kodilla.sudoku;

import java.io.*;
import java.util.Scanner;

public class CommandHandler {

    private SudokuGame game;
    private Scanner scanner;

    public CommandHandler(SudokuGame game) {
        this.game = game;
        scanner = new Scanner(System.in);
    }

    boolean checkPause(String command) {
        if (command.equalsIgnoreCase("pause")) {
            handlePause();
            return true;
        }
        return false;
    }

    public void checkGameEnd(String command) {
        if (command.equalsIgnoreCase("end")) {
            int[][] solvedBoard = game.solver.getSolution();
            game.solver.setBoard(solvedBoard);
            game.displayBoard();
            System.out.println("Correctly filled out board");
            System.exit(0);
        }
    }


    public void checkSaveGame(String command) {
        if (command.equalsIgnoreCase("save")) {
            saveGameMenu();
            System.exit(0);
        }
    }

    public void handlePause() {
        clearConsole();
        System.out.println("Game paused. Enter 'resume' to continue: ");
        while (true) {
            String command = scanner.next();
            if (!command.equalsIgnoreCase("resume")) {
                System.out.println("Invalid command. Enter 'resume' to continue: ");
            } else {
                break;
            }
        }
    }

    public void clearConsole() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void saveGameMenu() {
        try {
            FileOutputStream fileStream = new FileOutputStream("savedGame.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(game.solver.getBoard());
            objectStream.writeObject(game.solver.getGeneratedNumbers());
            objectStream.close();
            System.out.println("Game saved successfully.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error saving the game.");
            e.printStackTrace();
        }
    }

    public void loadGameMenu() {
        try {
            FileInputStream fileIn = new FileInputStream("savedGame.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            int[][] board = (int[][]) in.readObject();
            boolean[][] generatedNumbers = (boolean[][]) in.readObject();
            in.close();
            fileIn.close();

            game.solver.setBoard(board);
            game.solver.setGeneratedNumbers(generatedNumbers);
            System.out.println("Game loaded successfully.");

            game.continueLoadedGame();
        } catch (IOException e) {
            System.out.println("Error occurred while loading the game.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Saved game file not found.");
        }
    }
}