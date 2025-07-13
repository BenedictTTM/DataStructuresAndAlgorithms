import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Step 1: Choose sorting algorithm
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

        // Step 2: Enter array size
        int n = 0;
        while (true) {
            try {
                System.out.print("\nEnter number of elements: ");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear invalid input
            }
        }

        // Step 3: Enter array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; ) {
            try {
                System.out.print("Element " + (i + 1) + ": ");
                arr[i] = scanner.nextInt();
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear invalid input
            }
        }

        // Step 4: Sort and display
        switch (choice) {
            case 1:
                testSelectionSort(arr.clone());
                break;
            case 2:
                testBubbleSort(arr.clone());
                break;
        }

        scanner.close();
    }

    // =============================================
    // 1. Selection Sort
    // =============================================

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void testSelectionSort(int[] arr) {
        System.out.println("\nSelection Sort Flowchart:");
        printSelectionSortFlowchart();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted Array (Selection Sort): " + Arrays.toString(arr));

        System.out.println("\nAlgorithm Analysis:");
        System.out.println("Time Complexity: Θ(n²)");
    }

    public static void printSelectionSortFlowchart() {
        System.out.println("""
         +--------------------+
         |      Start         |
         +--------------------+
                  |
                  v
         +-----------------------------+
         | for i = 0 to n - 2          |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | minIndex = i                |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | for j = i+1 to n - 1        |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | if arr[j] < arr[minIndex]  |
         +-----------------------------+
             Yes | No
                  v
         +-----------------------------+
         | minIndex = j                |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | Swap arr[i] and arr[minIndex] |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         |            End              |
         +-----------------------------+
        """);
    }

    // =============================================
    // 2. Bubble Sort
    // =============================================

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void testBubbleSort(int[] arr) {
        System.out.println("\nBubble Sort Flowchart:");
        printBubbleSortFlowchart();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted Array (Bubble Sort): " + Arrays.toString(arr));

        System.out.println("\nAlgorithm Analysis:");
        System.out.println("Time Complexity: Θ(n²)");
    }

    public static void printBubbleSortFlowchart() {
        System.out.println("""
         +-------------------+
         |      Start        |
         +-------------------+
                 |
                 v
         +-----------------------------+
         | for i = 0 to n - 1          |
         +-----------------------------+
                 |
                 v
         +-----------------------------+
         | for j = 0 to n - i - 2      |
         +-----------------------------+
                 |
                 v
         +-----------------------------+
         | if arr[j] > arr[j+1]        |
         +-----------------------------+
             Yes | No
                 v
         +-----------------------------+
         | Swap arr[j] and arr[j+1]    |
         +-----------------------------+
                 |
                 v
         +-----------------------------+
         |            End              |
         +-----------------------------+
        """);
    }
}
