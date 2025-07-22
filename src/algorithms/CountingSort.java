package algorithms;
import java.util.*;

public class CountingSort {

    // Main counting sort algorithm (handles negatives)
    public static void countingSort(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int max = arr[0], min = arr[0];

        // Find range (min and max)
        for (int value : arr) {
            if (value > max) max = value;
            if (value < min) min = value;
        }

        int range = max - min + 1;
        int[] count = new int[range];

        // Count frequency
        for (int value : arr) {
            count[value - min]++;
        }

        // Overwrite original array with sorted elements
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Execute method for user interaction
    public void execute() {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // Get array size with validation
        while (true) {
            try {
                System.out.print("Enter number of elements: ");
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine(); // Clear invalid input
            }
        }

        int[] arr = new int[n];

        // Get array elements
        for (int i = 0; i < n; ) {
            try {
                System.out.print("Element " + (i + 1) + ": ");
                arr[i] = sc.nextInt();
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }

        // Display before sorting
        System.out.println("\nBefore sorting:");
        printArray(arr);

        // Sort
        countingSort(arr);

        // Display after sorting
        System.out.println("\nAfter sorting:");
        printArray(arr);

        // Flowchart and analysis
        printFlowchart();
        printAnalysis();
    }

    // Flowchart for visual reference
    public static void printFlowchart() {
        System.out.println("\nCounting Sort Flowchart:");
        System.out.println("""
         +--------------------+
         |      Start         |
         +--------------------+
                  |
                  v
         +-----------------------------+
         | Find min and max of array   |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | Create count array          |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | Count occurrences of each   |
         | element in input array      |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | Overwrite original array    |
         | with sorted elements        |
         +-----------------------------+
                  |
                  v
         +--------------------+
         |        End         |
         +--------------------+
        """);
    }

    // Time complexity analysis
    public static void printAnalysis() {
        System.out.println("\nAlgorithm Analysis:");
        System.out.println("Time Complexity: Θ(n + k), where n = number of elements and k = range of input.");
    }
}
