package gr.kiriweb.theater;

import java.util.Scanner;

/**
 * Theater Booking Management System
 *
 * This application manages seat bookings for a theater with 30 rows and 12 columns.
 * Each seat can be booked or canceled by the user through an interactive menu system.
 * The program displays the current seating arrangement and handles invalid inputs gracefully.
 *
 * Features:
 * - Book a seat by specifying column (A-L) and row (1-30).
 * - Cancel a booking for a specific seat.
 * - Display the current seating arrangement, showing booked seats as "X" and available seats as "O".
 * - Exit the program via the menu.
 *
 * Classes and Methods:
 * - `main(String[] args)`: The entry point of the program.
 * - `displayMenu()`: Displays the main menu options.
 * - `getUserChoice()`: Retrieves and validates the user's menu choice.
 * - `bookMenu()`: Handles user input for booking a seat.
 * - `cancelMenu()`: Handles user input for canceling a seat booking.
 * - `book(char column, int row)`: Books a specific seat if available.
 * - `cancel(char column, int row)`: Cancels a booking for a specific seat if already booked.
 * - `isValidSeat(char column, int row)`: Validates that the specified seat is within the valid range.
 * - `displaySeats()`: Displays the current theater seating chart.
 *
 * Input:
 * - The user interacts with the menu to book, cancel, or view seats.
 * - Columns are specified as single letters (A-L).
 * - Rows are specified as integers (1-30).
 *
 * Output:
 * - Messages indicating success or failure of booking/canceling operations.
 * - A seating chart showing the status of all seats.
 *
 * Example Usage:
 * - Enter "1" to book a seat. Specify the column and row as prompted.
 * - Enter "2" to cancel a booking. Specify the column and row as prompted.
 * - Enter "3" to view the seating chart.
 * - Enter "4" to exit the application.
 *
 * Author: Kyriakos Koutsourelis
 * Portfolio: https://github.com/Kiriweb
 */
public class TheaterBookingApp {
    // 2D array to represent the theater (static to access directly in main)
    public static final boolean[][] seats = new boolean[30][12];
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu(); // Display the menu
            int choice = getUserChoice(); // Get the user's choice

            // Process the user's choice
            switch (choice) {
                case 1 -> bookMenu(); // Book a seat
                case 2 -> cancelMenu(); // Cancel a booking
                case 3 -> displaySeats(); // Show the seating chart
                case 4 -> {
                    System.out.println("Exiting... Thank you for using the Theater Seat Management System.");
                    return; // Exit the program
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    // Method to display the menu
    public static void displayMenu() {
        System.out.println("\n--- Theater Seat Management ---");
        System.out.println("1. Book a Seat");
        System.out.println("2. Cancel a Booking");
        System.out.println("3. Show Theater Seats");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to get the user's choice
    public static int getUserChoice() {
        while (!scanner.hasNextInt()) { // Ensure valid integer input
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt(); // Return the valid choice
    }

    // Menu for booking a seat
    public static void bookMenu() {
        System.out.print("Enter the column (A-L): ");
        char column = scanner.next().toUpperCase().charAt(0); // Read column
        System.out.print("Enter the row (1-30): ");
        int row = scanner.nextInt(); // Read row

        book(column, row);
    }

    // Menu for canceling a booking
    public static void cancelMenu() {
        System.out.print("Enter the column (A-L): ");
        char column = scanner.next().toUpperCase().charAt(0); // Read column
        System.out.print("Enter the row (1-30): ");
        int row = scanner.nextInt(); // Read row

        cancel(column, row);
    }

    // Method to book a seat
    public static void book(char column, int row) {
        if (isValidSeat(column, row)) {
            int colIndex = column - 'A';
            int rowIndex = row - 1;

            if (!seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = true; // Mark the seat as booked
                System.out.println("Seat " + column + row + " has been booked.");
            } else {
                System.out.println("Error: Seat " + column + row + " is already booked.");
            }
        } else {
            System.out.println("Error: Invalid seat " + column + row + ".");
        }
    }

    // Method to cancel a booking
    public static void cancel(char column, int row) {
        if (isValidSeat(column, row)) {
            int colIndex = column - 'A';
            int rowIndex = row - 1;

            if (seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = false; // Mark the seat as available
                System.out.println("Seat " + column + row + " booking has been canceled.");
            } else {
                System.out.println("Error: Seat " + column + row + " is not booked.");
            }
        } else {
            System.out.println("Error: Invalid seat " + column + row + ".");
        }
    }

    // Method to check if a seat is valid
    private static boolean isValidSeat(char column, int row) {
        return column >= 'A' && column <= 'L' && row >= 1 && row <= 30;
    }

    // Method to display the current seating arrangement
    public static void displaySeats() {
        System.out.println("Theater Seating Chart:");
        System.out.print("   ");
        for (char col = 'A'; col <= 'L'; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int i = 0; i < 30; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < 12; j++) {
                if (seats[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}