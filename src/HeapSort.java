import java.util.Scanner;

public class HeapSort {

    // Heapify subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;           // Assume root is largest
        int left = 2 * i + 1;      // Left child
        int right = 2 * i + 2;     // Right child

        // Check if left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If root is not largest, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest); // Recursively heapify the affected subtree
        }
    }

    // Main heap sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility function to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Execute method to run the program
    public void execute() {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // Input array size with validation
        while (true) {
            try {
                System.out.print("Enter number of elements: ");
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine(); // Clear bad input
            }
        }

        // Create array
        int[] A = new int[n];

        // Input array elements with validation
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    A[i] = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.nextLine();
                }
            }
        }

        // Display before sorting
        System.out.println("\nBefore sorting:");
        printArray(A);

        // Sort array
        heapSort(A);

        // Display after sorting
        System.out.println("\nAfter sorting:");
        printArray(A);
    }
}

