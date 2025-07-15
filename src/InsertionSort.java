import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Get array size
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

        // Get array elements
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

        // Execute sorting and display results
        test(arr.clone());

        // Note: Not closing scanner as it uses System.in which should remain open
    }

    public void test(int[] arr) {
        System.out.println("\nInsertion Sort Flowchart:");
        printFlowchart();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array (Insertion Sort): " + Arrays.toString(arr));

        System.out.println("\nAlgorithm Analysis:");
        System.out.println("Time Complexity: Θ(n²) in worst case, Θ(n) in best case (already sorted)");
    }

    public void printFlowchart() {
        System.out.println("""
         +--------------------+
         |      Start         |
         +--------------------+
                  |
                  v
         +-----------------------------+
         | for i = 1 to n - 1          |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | key = arr[i], j = i - 1     |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | while j >= 0 and arr[j] > key|
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | arr[j+1] = arr[j], j--       |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | arr[j+1] = key               |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         |            End              |
         +-----------------------------+
        """);
    }
}
