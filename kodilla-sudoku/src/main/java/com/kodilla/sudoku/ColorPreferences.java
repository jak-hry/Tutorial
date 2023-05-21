package com.kodilla.sudoku;

import java.io.*;
import java.util.Properties;

public class ColorPreferences {

    public static void saveColorSelection(Color selectedColor, String fileName) {
        Properties properties = new Properties();
        properties.setProperty("numberDisplayColor", selectedColor.name());

        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            properties.store(outputStream, "Sudoku Game Settings");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nAn error occurred while saving the color selection. + \n");
        }
    }

    public static Color getColorSelection(String fileName) {
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
            String colorName = properties.getProperty("numberDisplayColor");
            return Color.valueOf(colorName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nAn error occurred while processing the file. " + fileName + "\n");
        }

        return Color.DEFAULT;
    }
}