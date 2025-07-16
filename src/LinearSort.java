import java.util.Arrays;

public class LinearSearch {

    // ========= TEST METHOD =========
    public static void testLinearSearch(int[] arr, int target) {
        System.out.println("\nLinear Search Flowchart:");
        printLinearSearchFlowchart();

        System.out.println("\nArray: " + Arrays.toString(arr));
        int index = linearSearch(arr, target);

        if (index != -1)
            System.out.println("Target " + target + " found at index: " + index);
        else
            System.out.println("Target " + target + " not found.");

        System.out.println("\nAlgorithm Analysis:\nTime Complexity: Θ(n)");
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