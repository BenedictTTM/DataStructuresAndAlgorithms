import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CountingSort {

    public void sort(int[] arr) {
        int n = arr.length;

        if (n == 0) return;

        int max = arr[0];
        int min = arr[0];

        // Find the range of input
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        int range = max - min + 1;

        // Initialize count array
        int[] count = new int[range];

        // Store the count of each element
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Overwrite arr with sorted elements
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
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
    }

    public void test(int[] arr) {
        System.out.println("\nCounting Sort Flowchart:");
        printFlowchart();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array (Counting Sort): " + Arrays.toString(arr));

        System.out.println("\nAlgorithm Analysis:");
        System.out.println("Time Complexity: Θ(n + k) where k = range of input");
    }

    public void printFlowchart() {
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
}
