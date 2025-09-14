import java.util.Scanner;

public class LibrarySystem {
    static final int MAX_BOOKS = 5;
    static String[] bookTitles = new String[MAX_BOOKS];
    static String[] bookStatus = new String[MAX_BOOKS];
    
    static int bookCount = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choice;

        do {
          System.out.println("————————————————————————");
            System.out.println("Campus Library System");
            System.out.println("\n1. Add Book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            while (!s.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                s.next();
            }
            choice = 
            s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    addBook(s);
                    break;
                case 2:
                    updateBookStatus(s);
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        } while (choice != 5);

        s.close();
    }

    public static void addBook(Scanner s) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Book limit reached! Cannot add more books.");
            return;
        }

        System.out.print("Enter book title: ");
        String title = s.nextLine();

        bookTitles[bookCount] = title;
        bookStatus[bookCount] = "Available";
        bookCount++;

        System.out.println("Book \"" + title + "\" added successfully.");
    }

    public static void updateBookStatus(Scanner s) {
        if (bookCount == 0) {
            System.out.println("No books in the system to update.");
            return;
        }

        showBooks();
        System.out.print("Enter book number to borrow/return: ");
        
        while (!s.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid book number.");
            s.next();
        }
        int bookNumber = s.nextInt();
        s.nextLine();

        if (bookNumber < 1 || bookNumber > bookCount) {
            System.out.println("Invalid book number.");
            return;
        }

        int index = bookNumber - 1;
        if (bookStatus[index].equals("Available")) {
            bookStatus[index] = "Borrowed";
            System.out.println("Book \"" + bookTitles[index] + "\" is now Borrowed.");
        } else {
            bookStatus[index] = "Available";
            System.out.println("Book \"" + bookTitles[index] + "\" is now Available.");
        }
    }

    public static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books registered yet.");
            return;
        }

        System.out.println("\n--- List of Books ---");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ". " + bookTitles[i] + " [" + bookStatus[i] + "]");
        }
    }
    
    public static void generateReport() {
        if (bookCount == 0) {
            System.out.println("No books available for report.");
            return;
        }

        int availableCount = 0, borrowedCount = 0;
        for (int i = 0; i < bookCount; i++) {
            if (bookStatus[i].equals("Available")) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("\n--- Library Report ---");
        System.out.println("Total books: " + bookCount);
        System.out.println("Available books: " + availableCount);
        System.out.println("Borrowed books: " + borrowedCount);
    }
              }
          
