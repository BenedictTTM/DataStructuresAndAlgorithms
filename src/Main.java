import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            int categoryChoice = -1;

            // Step 1: Ask Search or Sort or Exit
            while (true) {
                try {
                    System.out.println("\nWhat would you like to do?");
                    System.out.println("1. Sorting");
                    System.out.println("2. Searching");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice (1, 2, or 3): ");
                    categoryChoice = scanner.nextInt();

                    if (categoryChoice < 1 || categoryChoice > 3) {
                        System.out.println("Please enter 1, 2, or 3.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                }
            }

            if (categoryChoice == 3) {
                System.out.println("Exiting program. Goodbye!");
                running = false;
                continue;
            }

            // Sorting path: Choose Sorting Algorithm
            if (categoryChoice == 1) {
                int sortChoice = -1;
                while (true) {
                    try {
                        System.out.println("\nChoose a Sorting Algorithm:");
                        System.out.println("1. Selection Sort");
                        System.out.println("2. Bubble Sort");
                        System.out.println("3. Shell Sort");
                        System.out.println("4. Go Back");

                        // System.out.println("4. Heap Sort");
                        System.out.print("Enter your choice (1–3): ");
                        sortChoice = scanner.nextInt();

                        if (sortChoice < 1 || sortChoice > 4) {
                            System.out.println("Please enter a number between 1 and 3.");
                        } else {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next(); // clear invalid input
                    }
                }

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
                        // takes us back to the main menu
                        continue;
                    // case 5:
                    //     new HeapSort().execute();
                    //     break;
                }

            // Searching path
            } else if (categoryChoice == 2) {
                int searchChoice = -1;
                while (true) {
                    try {
                        System.out.println("\nSearching Algorithms Available:");
                        System.out.println("1. Binary Search");
                        System.out.println("2. Go Back");//After you add other Searching lgorithms, still keep the Go back always at the last end. 
                        System.out.print("Press 1 to proceed: ");
                        searchChoice = scanner.nextInt();

                        if (searchChoice < 1 || searchChoice > 2) {
                            System.out.println("Please enter 1 or 2");
                            //
                           // break;
                        }else{
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("Invalid input. Press 1 to continue: ");
                        scanner.next();
                    }
                }

                switch (searchChoice) {
                    case 1:
                        new BinarySearch().execute();
                        break;
                    case 2:
                        //Go back to main
                        continue;
                }
            }
        }

        scanner.close();
    }
}