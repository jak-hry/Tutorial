package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RpsRunner {

    private static boolean end = false;
    private static Scanner scanner = new Scanner(System.in);
    private static AtomicInteger playerWins = new AtomicInteger(0);
    private static AtomicInteger computerWins = new AtomicInteger(0);
    private static int roundsToWin;

    public static void main(String[] args) {
        String playerName = getPlayerName();
        howManyRounds(playerName);

        while (!end) {
            showResult(playerName, playerWins, computerWins);
            switch (getPlayerInput()) {
                case 1, 2, 3 -> playRound(playerName, computerChoice(), playerWins, computerWins, roundsToWin);
                case 4 -> endGame(playerName, playerWins, computerWins);
                case 5 -> resetGame(playerWins, computerWins);
                default -> System.out.println("\nWrong number, try again");
            }
        }
    }

    private static void howManyRounds(String playerName) {
        System.out.println("Hi " + playerName + ", how many rounds do you want to play to win?");
        while (true) {
            try {
                roundsToWin = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInput must be a number, try again");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
    }

    private static String getPlayerName() {
        System.out.println("Welcome to Rock, Paper, Scissors game!");
        System.out.println("Please enter your name:");
        String playerName = scanner.nextLine();
        return playerName;
    }

    public static void endGame(String playerName, AtomicInteger playerWins, AtomicInteger computerWins) {
        System.out.println("\nGame over!");
        showResult(playerName, playerWins, computerWins);
        System.out.println("\nPress 'x' to exit or 'n' to start a new game");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("x")) {
                endGame(playerName, playerWins, computerWins);
            } else if (choice.equals("n")) {
                resetGame(playerWins, computerWins);
                break;
            } else {
                System.out.println("\nWrong input, try again");
            }
        }
    }

    public static void resetGame(AtomicInteger playerWins, AtomicInteger computerWins) {
        System.out.println("\nStarting a new game!");
        playerWins.set(0);
        computerWins.set(0);
        System.out.println("How many rounds do you want to play to win?");
        while (true) {
            try {
                roundsToWin = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nInput must be a number, try again");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
    }

    private static int getPlayerInput() {
        while (true) {
            try {
                System.out.println("\nPlease choose:");
                System.out.println("1- Rock");
                System.out.println("2- Paper");
                System.out.println("3- Scissors");
                System.out.println("4- Quit");
                System.out.println("5- Restart game");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInput must be a number, try again");
                scanner.nextLine();
            }
        }
    }

    private static void playRound(String playerName, String playerChoice, AtomicInteger playerWins,
                                  AtomicInteger computerWins, int roundsToWin) {
        String computerChoice = computerChoice();

        if (playerChoice.equals(computerChoice)) {
            System.out.println("\n\n\n\n\n\nIt's a tie!");
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            playerWins.getAndIncrement();
            System.out.println("\n\n\n\n\n\nYou win!");

            if (playerWins.get() >= roundsToWin) {
                showResult(playerName, playerWins, computerWins);
                System.out.println("Congratulations! You won the game!");
                startNewGame(playerWins, computerWins);
            }
        } else {
            computerWins.getAndIncrement();
            System.out.println("\n\n\n\n\n\nComputer wins!");

            if (computerWins.get() >= roundsToWin) {
                showResult(playerName, playerWins, computerWins);
                System.out.println("Sorry, you lost the game.");
                startNewGame(playerWins, computerWins);
            }
        }
    }

    private static void showResult(String playerName, AtomicInteger playerWins, AtomicInteger computerWins) {
        int totalRounds = playerWins.get() + computerWins.get();
        System.out.println("\nRounds played: " + totalRounds);
        System.out.println(playerName + ": " + playerWins.get() + " vs " + computerWins.get() + " :Computer");
    }

    private static void startNewGame(AtomicInteger playerWins, AtomicInteger computerWins) {
        playerWins.set(0);
        computerWins.set(0);
        System.out.println("\nPress 'n' to start a new game or 'x' to exit.");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toLowerCase();
        while (!choice.equals("n") && !choice.equals("x")) {
            System.out.println("\nWrong input. Please enter 'n' or 'x'.");
            choice = scanner.nextLine().toLowerCase();
        }

        if (choice.equals("n")) {
            System.out.println("\nStarting a new game!");
        } else {
            System.out.println("\nThanks for playing! Goodbye!");
            System.exit(0);
        }
    }

    private static String computerChoice() {
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        int computerIndex = random.nextInt(choices.length);
        return choices[computerIndex];
    }
}
