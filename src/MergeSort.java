import java.util.Arrays;

public class MergeSort {

    // =============================================
    // 3. Merge Sort
    // =============================================

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void testMergeSort(int[] arr) {
        System.out.println("\nMerge Sort Flowchart:");
        printMergeSortFlowchart();

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array (Merge Sort): " + Arrays.toString(arr));

        System.out.println("\nAlgorithm Analysis:");
        System.out.println("Time Complexity: Θ(n log n)");
    }

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
