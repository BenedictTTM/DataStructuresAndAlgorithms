import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {  // keep running until user chooses to exit
            int categoryChoice = -1;

            // Step 1: Ask Search, Sort, or Exit
            while (true) {
                try {
                    System.out.println("\nWhat would you like to do?");
                    System.out.println("1. Sorting");
                    System.out.println("2. Searching");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice (1, 2, or 3): ");
                    categoryChoice = scanner.nextInt();

                    if (categoryChoice >= 1 && categoryChoice <= 3) {
                        break;
                    } else {
                        System.out.println("Please enter 1, 2, or 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                }
            }

            if (categoryChoice == 3) {
                System.out.println("Exiting program. Goodbye!");
                break;  // clean exit from the loop
            }

            // Sorting path
            if (categoryChoice == 1) {
                handleSorting(scanner);
            }

            // Searching path
            else if (categoryChoice == 2) {
                handleSearching(scanner);
            }
        }

        scanner.close();
    }

    // Method to handle sorting with back option
    public static void handleSorting(Scanner scanner) {
        while (true) {
            int sortChoice = -1;
            System.out.println("\nChoose a Sorting Algorithm:");
            System.out.println("1. Selection Sort");
            System.out.println("2. Bubble Sort");
            System.out.println("3. Shell Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Heap Sort");
            System.out.println("6. Quick Sort");
            System.out.println("7. Merge Sort");
            System.out.println("8. Counting Sort");
            System.out.println("9. Insertion Sort");
            System.out.println("10. Back to Main Menu");

            System.out.print("Enter your choice (1-10): ");

            try {
                sortChoice = scanner.nextInt();

                if (sortChoice >= 1 && sortChoice <= 9) {
                    switch (sortChoice) {
                        case 1:
                            new SelectionSort().execute();
                            break;
                        case 2:
                            new BubbleSort().execute();
                            break;
                        case 3:
                            new ShellSort().execute();
                            break;
                        case 4:
                            new RadixSort().execute();
                            break;
                        case 5:
                            new HeapSort().execute();
                            break;
                        case 6:
                            new QuickSort().execute();
                            break;
                        case 7:
                            new MergeSort().execute();
                            break;
                        case 8:
                            new CountingSort().execute();
                            break;
                        case 9:
                            new InsertionSort().execute();
                            break;
                    }
                } else if (sortChoice == 10) {
                    System.out.println("Returning to main menu...");
                    break;  // exit sorting loop
                } else {
                    System.out.println("Please enter a number between 1 and 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }
    }

    // Method to handle searching with back option
    public static void handleSearching(Scanner scanner) {
        while (true) {
            int searchChoice = -1;
            System.out.println("\nChoose a Searching Algorithm:");
            System.out.println("1. Binary Search");
            System.out.println("2. Linear Search");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice (1-3): ");

            try {
                searchChoice = scanner.nextInt();

                if (searchChoice == 1) {
                    new BinarySearch().execute();
                } else if (searchChoice == 2) {
                    new LinearSearch().execute();
                } else if (searchChoice == 3) {
                    System.out.println("Returning to main menu...");
                    break;  // exit searching loop
                } else {
                    System.out.println("Please enter 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }
    }
}
