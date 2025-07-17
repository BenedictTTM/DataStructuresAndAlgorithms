import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int categoryChoice = -1;

        // Step 1: Ask Search or Sort
        while (true) {
            try {
                System.out.println("What would you like to do?");
                System.out.println("1. Sorting");
                System.out.println("2. Searching");
                System.out.print("Enter your choice (1 or 2): ");
                categoryChoice = scanner.nextInt();

                if (categoryChoice != 1 && categoryChoice != 2) {
                    System.out.println("Please enter 1 or 2.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
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
                    System.out.println("4. Radix Sort");
                    System.out.println("5. Heap Sort");
                    System.out.println("6. Quick Sort");
                    System.out.println("7. Merge Sort");
                    System.out.println("8. Counting Sort");
                    System.out.println("9. Insertion Sort");

                    System.out.print("Enter your choice (1-9): ");
                    sortChoice = scanner.nextInt();

                    if (sortChoice < 1 || sortChoice > 5) {
                        System.out.println("Please enter a number between 1 and 9.");
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
                    new RadixSort().execute();
                    break;
                case 5:
                    new HeapSort().execute();
                    break;
                case 6:
                    //new QuickSort().execute();
                    break;
                case 7:
                    //new MergeSort().execute();
                    break;
                case 8:
                    //new CountingSort().execute();
                    break;
                case 9:
                    new InsertionSort().execute();
                    break;
            }

            // Step 3: Searching path
        } else if (categoryChoice == 2) {
            System.out.println("\nSearching Algorithms Available:");
            System.out.println("1. Binary Search");
            System.out.println("2. Linear Search");
            System.out.print("Press 1 or 2 to proceed: ");
            
            int searchChoice = -1;
            while (true) {
                try {
                    searchChoice = scanner.nextInt();
                     if (searchChoice == 1) {
                        new BinarySearch().execute();
                        break;
                    } else if (searchChoice == 2) {
                        new LinearSearch().execute();
                        break;
                    } else {
                        System.out.println("Please enter 1 or 2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Press 1 or 2 to continue: ");
                    scanner.next();
                }
            }
        }

        scanner.close();
    }
}