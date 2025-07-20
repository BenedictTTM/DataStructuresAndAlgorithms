import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LinearSearch {


    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Input array size with validation
        int n = 0;
        while (true) {
            try {
                System.out.print("Enter number of elements: ");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear bad input
            }
        }

        // Create array and input elements with validation
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    arr[i] = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine(); // Clear bad input
                }
            }
        }

        // Input target value with validation
        int target = 0;
        while (true) {
            try {
                System.out.print("Enter target value to search for: ");
                target = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear bad input
            }
        }

        // Perform linear search
        System.out.println("\nLinear Search Flowchart:");
        printLinearSearchFlowchart();

        Arrays.sort(arr);
        System.out.println("\nSorted Array: " + Arrays.toString(arr));
        int index = linearSearch(arr, target);

        if (index != -1)
            System.out.println("Target " + target + " found at index: " + index);
        else
            System.out.println("Target " + target + " not found.");

        System.out.println("\nAlgorithm Analysis:\nTime Complexity: Θ(n)");

        //scanner.close();
    }

    // ========= LINEAR SEARCH METHOD =========
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // ========= FLOWCHART =========
    public static void printLinearSearchFlowchart() {
        System.out.println("""
         +--------------------+
         |      Start         |
         +--------------------+
                  |
                  v
         +-----------------------------+
         |   For i = 0 to n - 1        |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | arr[i] == target?           |
         +-----------------------------+
              /          \\
            Yes           No
            /               \\
           v                 v
+------------------+     +---------------------+
| return index i   |     | Continue loop       |
+------------------+     +---------------------+
                                |
                                v
                   +------------------------+
                   |     Target not found   |
                   |     return -1          |
                   +------------------------+
        """);
    }
}