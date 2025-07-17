import java.util.Scanner;

public class MergeSort {

    // Recursive merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Sorting function to call recursive mergeSort
    public static void sort(int[] arr) {
        if (arr.length > 1) {
            mergeSort(arr, 0, arr.length - 1);
        }
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Execute method to run interactively
    public void execute() {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // Input array size
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
                sc.nextLine(); // clear buffer
            }
        }

        int[] arr = new int[n];

        // Input elements
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    arr[i] = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.nextLine(); // clear buffer
                }
            }
        }

        // Display before sorting
        System.out.println("\nBefore sorting:");
        printArray(arr);

        // Sort array
        sort(arr);

        // Display after sorting
        System.out.println("\nAfter sorting:");
        printArray(arr);
    }
}
