import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuickSort {

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("\n=== QUICK SORT OPTIONS ===");
        System.out.println("1. Basic Quick Sort");
        System.out.println("2. Quick Sort (Handles Duplicates)");
        System.out.print("Enter your choice: ");

        try {
            choice = scanner.nextInt();
            if (choice == 1) {
                new QuickSortBasic().run();
            } else if (choice == 2) {
                new QuickSortWithDuplicates().run();
            } else {
                System.out.println("Invalid choice. Returning to main menu.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear input
        }
    }

    static class QuickSortBasic {
        void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

            System.out.println("Original array: " + Arrays.toString(arr));
            quickSort(arr, 0, n - 1);
            System.out.println("Sorted (Basic Quick Sort): " + Arrays.toString(arr));

            printFlowchart();
        }

        void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }

        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        void printFlowchart() {
            System.out.println("""
                    +------------------------+
                    |      Quick Sort        |
                    +------------------------+
                              |
                    +------------------------+
                    |  Pick last element as  |
                    |        pivot           |
                    +------------------------+
                              |
                    +------------------------+
                    |  Partition the array   |
                    +------------------------+
                           /          \\
                    QuickSort      QuickSort
                    (low, pi-1)     (pi+1, high)
                              |
                             Done
                    """);
        }
    }

    static class QuickSortWithDuplicates {
        void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of elements (with duplicates): ");
            int n = scanner.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

            System.out.println("Original array: " + Arrays.toString(arr));
            quickSort(arr, 0, n - 1);
            System.out.println("Sorted (Handles Duplicates): " + Arrays.toString(arr));

            printFlowchart();
        }

        void quickSort(int[] arr, int low, int high) {
            if (low >= high) return;

            int pivot = arr[high];
            int lt = low, gt = high;
            int i = low;

            while (i <= gt) {
                if (arr[i] < pivot) {
                    swap(arr, lt++, i++);
                } else if (arr[i] > pivot) {
                    swap(arr, i, gt--);
                } else {
                    i++;
                }
            }

            quickSort(arr, low, lt - 1);
            quickSort(arr, gt + 1, high);
        }

        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        void printFlowchart() {
            System.out.println("""
                    +--------------------------------+
                    |   Quick Sort with Duplicates   |
                    +--------------------------------+
                                |
                    +--------------------------------+
                    |   Pick pivot (last element)     |
                    +--------------------------------+
                                |
                    +--------------------------------+
                    | Partition into 3 regions:       |
                    |  < pivot | = pivot | > pivot    |
                    +--------------------------------+
                          /                  \\
                    quickSort           quickSort
                   (low, lt-1)         (gt+1, high)
                                |
                               Done
                    """);
        }
    }
}
