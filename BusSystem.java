import java.util.Scanner;
// import java.util.Random;

public class BusSystem {
    static String[] seats = {
        "01","02","03","04","05",
        "06","07","08","09","10",
        "11","12","13","14","15",
        "16","17","18","19","20"
    };
  
  static boolean[] isBooked = new boolean[20];
  static String[] passengerName = new String[20];
  static final double ticketPrice = 150.0;
  static final String GREEN = "\u001B[38;5;10m";
  static final String RED = "\u001B[91m";
  static final String RESET = "\u001B[0m";
  static final String LINE = "————————————————————";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        System.out.println(GREEN + "ORVILLE EXPRESS - Manila to Cavite" + RESET);

        while (choice != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. Show Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                showSeats();
            } else if (choice == 2) {
                bookSeat(sc);
            } else if (choice == 3) {
                cancelSeat(sc);
            } else if (choice == 4) {
                System.out.println( GREEN + "Thank you for riding with Orville Express! Safe trip!" + RESET);
            } else {
                System.out.println(RED + "Invalid choice. Try again." + RESET);
            }
        }
    }

    static void showSeats() {
        System.out.println(GREEN + "\n--- BUS SEAT MAP ---" + RESET);
        for (int i = 0; i < seats.length; i++) {
            if (isBooked[i]) {
                System.out.print(seats[i] + "🟥 ");
            } else {
                System.out.print(seats[i] + "🟩 ");
            }

            if (i % 2 == 1) {
                System.out.println();
            }
        }
    }

    static void bookSeat(Scanner sc) {
        showSeats();
        System.out.print("\nEnter seat number to book (01 - 20): ");
        String seatChoice = sc.nextLine();

        int index = findSeat(seatChoice);
        if (index == -1) {
            System.out.println(RED + "Seat number does not exist." + RESET);
        } else if (isBooked[index]) {
            System.out.println("Seat " + seatChoice + " is already booked.");
        } else {
            System.out.print("Enter passenger name: ");
            String name = sc.nextLine();
            isBooked[index] = true;
            passengerName[index] = name;

            System.out.println(GREEN + "\n-- ORVILLE EXPRESS ---");
            System.out.println("--- OFFICIAL RECEIPT ---" + RESET);
            System.out.println("\nPASSENGER: " + name);
            System.out.println("SEAT NO: " + seatChoice);
            System.out.println("ROUTE: Manila to Cavite");
            System.out.println("FARE: ₱" + TICKET_PRICE);
            System.out.println("-------------------------");
        }
    }
    
    static void cancelSeat(Scanner sc) {
        showSeats();
        System.out.print("\nEnter seat no. to cancel: ");
        String seatChoice = sc.nextLine();

        int index = findSeat(seatChoice);
        if (index == -1) {
            System.out.println(RED + "Seat number does not exist." + RESET);
        } else if (!isBooked[index]) {
            System.out.println("Seat " + seatChoice + " is not booked.");
        } else {
            System.out.println("Booking for " + passengerName[index] + " (Seat " + seatChoice + ") canceled.");
            isBooked[index] = false;
            passengerName[index] = null;
        }
    }

    static int findSeat(String seatChoice) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals(seatChoice)) {
                return i;
            }
        }
        return -1;
    }
                                 }
