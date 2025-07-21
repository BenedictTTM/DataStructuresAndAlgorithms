package algorithms;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectionSort {
    
    public void sort(int[] arr) {
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
        System.out.println("\nSelection Sort Flowchart:");
        printFlowchart();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted Array (Selection Sort): " + Arrays.toString(arr));

        System.out.println("\nAlgorithm Analysis:");
        System.out.println("Time Complexity: Θ(n²)");
    }

    public void printFlowchart() {
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
}
