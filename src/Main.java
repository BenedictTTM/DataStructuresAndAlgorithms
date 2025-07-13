import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Choose sorting algorithm
        while (true) {
            try {
                System.out.println("Choose Sorting Algorithm:");
                System.out.println("1. Selection Sort");
                System.out.println("2. Bubble Sort");
                System.out.print("Enter your choice (1 or 2): ");
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Please enter 1 or 2.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.next(); // clear invalid input
            }
        }

        // Create object and execute
        switch (choice) {
            case 1:
                SelectionSort selectionSort = new SelectionSort();
                selectionSort.execute();
                break;
            case 2:
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.execute();
                break;
        }

        scanner.close();
    }
}
