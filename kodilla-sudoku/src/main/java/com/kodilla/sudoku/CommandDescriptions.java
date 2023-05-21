package com.kodilla.sudoku;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandDescriptions {

    private static Scanner scanner;

    public CommandDescriptions() {
        scanner = new Scanner(System.in);
    }

    public void displayCommandInfo() {
        while (true) {
            try {
                System.out.println("\n--------------------------------------");
                System.out.println("Useful Commands: Enter a number to view the command description: \n");
                System.out.println("1 - Command \"pause\"");
                System.out.println("2 - Command \"end\"");
                System.out.println("3 - Command \"save\"");
                System.out.println("\n9 - Main menu");
                System.out.println("--------------------------------------");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        displayPauseDesc();
                        continue;
                    case 2:
                        displayEndDesc();
                        break;
                    case 3:
                        displaySaveDesc();
                        break;
                    case 9:
                        return;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("\nCommand Descriptions: Enter a number to see the details: ");
                scanner.nextLine();
            }
        }
    }

    public void displayPauseDesc() {
        System.out.println("\nCommand \"pause\":");
        System.out.println("This command allows you to pause the game and temporarily suspend the gameplay.");
        System.out.println("To resume the game, you need to enter the command \"resume\".");
        backToCommandsMenu();
    }

    public void displayEndDesc() {
        System.out.println("\nCommand \"end\":");
        System.out.println("This command allows you to end the game and reveal the solution to the Sudoku puzzle.");
        backToCommandsMenu();
    }

    public void displaySaveDesc() {
        System.out.println("\nCommand \"save\":");
        System.out.println("This command allows you to save the current state of the game, so you can resume it later.");
        backToCommandsMenu();
    }

    private void backToCommandsMenu() {
        System.out.println("\n\n\nTo go back to the list of commands, enter \"back\".");
        String input = scanner.next();
        if (input.equalsIgnoreCase("back")) {
            displayCommandInfo();
        }
    }
}
