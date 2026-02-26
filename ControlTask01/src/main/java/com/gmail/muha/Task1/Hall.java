package com.gmail.muha.Task1;

public class Hall {
    private static char[][] hall;
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        hall = initialHall(10, 10);

        displayingCurrentHall(hall);

        reservationOfPlace(6, 7);

        displayingCurrentHall(hall);

        cancellationOfReservation(3, 3);

        displayingCurrentHall(hall);

        countingFreeAndOccupiedPlaces();
    }

    private static char[][] initialHall(int row, int place) {

        char[][] hall = new char[row][place];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < place; j++) {
                hall[i][j] = 'F';
            }
        }
        return hall;
    }

    private static void displayingCurrentHall(char[][] hall) {

        System.out.print("    ");
        for (int i = 0; i < hall[0].length; i++) {
            System.out.printf(" %-3d", (i + 1));
        }
        System.out.println();

        printHorizontalLine(hall[0].length);

        for (int i = 0; i < hall.length; i++) {

            System.out.printf("%-3d|", (i + 1));

            for (int j = 0; j < hall[i].length; j++) {

                if (hall[i][j] == 'B') {
                    System.out.printf("%s %c %s|", RED, hall[i][j], RESET);

                } else {
                    System.out.printf(" %c |", hall[i][j]);
                }
            }
            System.out.println();
            printHorizontalLine(hall[0].length);
        }
    }

    private static void printHorizontalLine(int columns) {
        System.out.print("   +");
        for (int i = 0; i < columns; i++) {
            System.out.print("---+");
        }
        System.out.println();
    }

    private static void reservationOfPlace(int row, int place) {
        if (hall[row - 1][place - 1] == 'F') {
            System.out.println("Take your ticket for row " + row + ", place " + place);
            hall[row - 1][place - 1] = 'B';
        } else {
            System.out.println(RED + "Is this place taken" + RESET);
        }
    }

    private static void cancellationOfReservation(int row, int place) {
        if (hall[row - 1][place - 1] == 'B') {
            System.out.println("Your reservation has been cancelled");
            hall[row - 1][place - 1] = 'F';
        } else {
            System.out.println(RED + "Error: This place was not booked." + RESET);
            System.out.println("А этот — обычным.");
        }
    }

    private static void countingFreeAndOccupiedPlaces() {
        int countFree = 0;
        int countOccupied = 0;

        for (char[] row : hall) {
            for (char place : row) {
                if (place == 'F') {
                    countFree++;
                } else {
                    countOccupied++;
                }
            }
        }
        System.out.println("Free place: " + countFree + ", Occupied place: " + countOccupied);
    }
}
