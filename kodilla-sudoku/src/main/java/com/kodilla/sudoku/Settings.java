package com.kodilla.sudoku;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Settings {

    public final static String NUMBER_COLOR_PROPERTIES = "numberColor.properties";
    public final static String BOARD_BORDER_COLOR_PROPERTIES = "borderColor.properties";
    private static Scanner scanner;
    private static Color[] colors;

    public Settings() {
        scanner = new Scanner(System.in);
        colors = Color.values();
    }

    public void showSettingsMenu() {
        while (true) {
            try {
                System.out.println("\n--------------------------------------");
                System.out.println("Settings: \n");
                System.out.println("1 - Number Display Color Selection");
                System.out.println("2 - Game Board Border Color Selection");
                System.out.println("\n9 - Main menu");
                System.out.println("--------------------------------------");
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        chooseColorSelection(NUMBER_COLOR_PROPERTIES);
                        break;
                    case 2:
                        chooseColorSelection(BOARD_BORDER_COLOR_PROPERTIES);
                        break;
                    case 9:
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private static void chooseColorSelection(String propertiesFile) {
        while (true) {
            try {
                System.out.println("\nAvailable color options:");
                for (int i = 0; i < colors.length; i++) {
                    System.out.print((i + 1) + " - " + colors[i].name().substring(0, 1).toUpperCase()
                            + colors[i].name().substring(1).toLowerCase() + colors[i].getDisplayName()
                            + " ("  + "Example text in the color" + ")");
                    System.out.println(Color.DEFAULT.getDisplayName());
                }

                System.out.println("\nPlease enter the number corresponding to the color you want to choose:");
                int colorIndex = scanner.nextInt();

                if (colorIndex < 1 || colorIndex > colors.length) {
                    System.out.println("Invalid color selection. Please choose a valid color.");
                } else {
                    Color selectedColor = colors[colorIndex - 1];
                    System.out.println("Selected color: " + selectedColor.getDisplayName()
                            + selectedColor.name().substring(0, 1).toUpperCase()
                            + selectedColor.name().substring(1).toLowerCase()
                            + Color.DEFAULT.getDisplayName());

                    ColorPreferences.saveColorSelection(selectedColor, propertiesFile);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("An error occurred while processing the input.");
                e.printStackTrace();
                scanner.nextLine();
            }
        }
    }
}