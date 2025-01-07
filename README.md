# Theater Booking Management System

## Project Overview
The Theater Booking Management System is a Java application for managing seat reservations in a theater with 30 rows and 12 columns. The system provides an interactive menu that allows users to book or cancel seats and view the current seating arrangement.

### Features
- **Book a Seat**: Reserve a specific seat in the theater by specifying the row (1-30) and column (A-L).
- **Cancel a Booking**: Cancel an existing reservation for a specific seat.
- **View Seating Chart**: Display the current seating arrangement with:
  - `"X"` indicating booked seats.
  - `"O"` indicating available seats.
- **Exit the Application**: Close the program via the menu.
- Handles invalid inputs gracefully, ensuring a smooth user experience.

---

## How It Works

1. **Menu Options**:
   - Users interact with a menu to perform actions:
     1. Book a seat.
     2. Cancel a booking.
     3. View the seating chart.
     4. Exit the application.

2. **Seating Representation**:
   - The theater is represented as a `30x12` 2D array of `boolean` values:
     - `true` → Seat is booked.
     - `false` → Seat is available.

3. **Input Validation**:
   - Ensures column input is a single letter (`A-L`).
   - Ensures row input is a number (`1-30`).
   - Handles invalid menu choices and non-integer inputs.

---

## Project Structure
```
theater-booking-app/
├── src/
│   └── gr/
│       └── kiriweb/
│           └── theater/
│               └── TheaterBookingApp.java  # Main application file
└── README.md                               # Project documentation
```

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/theater-booking-app.git
   ```
2. Navigate to the project directory:
   ```bash
   cd theater-booking-app/src/gr/kiriweb/theater
   ```
3. Compile the Java program:
   ```bash
   javac TheaterBookingApp.java
   ```

---

## Usage
1. Run the program:
   ```bash
   java TheaterBookingApp
   ```

2. Follow the on-screen menu prompts to:
   - Book a seat.
   - Cancel a booking.
   - View the seating chart.
   - Exit the application.

---

## Example Usage

### Menu:
```
--- Theater Seat Management ---
1. Book a Seat
2. Cancel a Booking
3. Show Theater Seats
4. Exit
Enter your choice: 1
```

### Booking a Seat:
```
Enter the column (A-L): C
Enter the row (1-30): 2
Seat C2 has been booked.
```

### Canceling a Seat:
```
Enter the column (A-L): C
Enter the row (1-30): 2
Seat C2 booking has been canceled.
```

### Viewing the Seating Chart:
```
Theater Seating Chart:
    A B C D E F G H I J K L
 1  O O O O O O O O O O O O
 2  O O O O O O O O O O O O
...
30 O O O O O O O O O O O O
```

---

## Author
- **Kyriakos Koutsourelis**
- GitHub: [https://github.com/Kiriweb](https://github.com/Kiriweb)

---