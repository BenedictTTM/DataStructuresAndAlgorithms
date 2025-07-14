import java.util.Arrays;

public class MergeSort {

    // ========= TEST METHOD =========
    public static void testMergeSort(int[] arr) {
        System.out.println("\nMerge Sort Flowchart:");
        printMergeSortFlowchart();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        mergeSort(arr.clone(), 0, arr.length - 1);  // Recursive
        System.out.println("Sorted (Recursive Merge Sort): " + Arrays.toString(arr));

        int[] arr2 = arr.clone();
        iterativeMergeSort(arr2);  // Iterative
        System.out.println("Sorted (Iterative Merge Sort): " + Arrays.toString(arr2));

        System.out.println("\nAlgorithm Analysis:\nTime Complexity: Θ(n log n)");
    }

    // ========= 1. RECURSIVE MERGE SORT =========
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // ========= 2. ITERATIVE MERGE SORT =========
    public static void iterativeMergeSort(int[] arr) {
        int n = arr.length;

        // Start with subarrays of size 1 and double each time
        for (int currSize = 1; currSize < n; currSize *= 2) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
                int mid = Math.min(leftStart + currSize - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);
                merge(arr, leftStart, mid, rightEnd);
            }
        }
    }

    // ========= COMMON MERGE METHOD =========
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

    // ========= FLOWCHART =========
    public static void printMergeSortFlowchart() {
        System.out.println("""
         +--------------------+
         |      Start         |
         +--------------------+
                  |
                  v
         +-----------------------------+
         | if left < right             |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         | mid = (left + right) / 2    |
         +-----------------------------+
            /              \\
           v                v
    +----------------+  +----------------+
    | mergeSort left |  | mergeSort right|
    +----------------+  +----------------+
            \\              /
             v            v
         +-----------------------------+
         |     merge(left, mid, right) |
         +-----------------------------+
                  |
                  v
         +-----------------------------+
         |            End              |
         +-----------------------------+
        """);
    }
}
