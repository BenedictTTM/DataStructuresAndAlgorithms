import java.util.Scanner;

public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length; // Total number of elements

        // Start with a gap of 2, reduce the gap by half on each iteration till gap is 0.
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i]; // Stores gap value in temporary variable.
                int j = i; // To move backward

                // Insertion sort step
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp; // Inserting value in temp to correct spot
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) { // For each value in the the array
            System.out.print(value + " "); // print value
        }
        System.out.println();
    }

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

        // Create array of size n specifies by user
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

        //Sort array
        shellSort(A);

        //Display after sorting
        System.out.println("\nAfter sorting:");
        printArray(A);
    }
}

/*
    | **Case**    | **Time Complexity** | **Explanation**                                    |
| ----------- | ------------------- | -------------------------------------------------- |
| **Best**    | **O(n log n)**      | Case where array is nearly sorted.                         |
| **Average** | **O(n (log n)²)**   | Heavily dependent on the gap sequence.               |
| **Worst**   | **O(n²)**           | Happens with poor gap sequence or bad input order. |

*/

/*
Start
  |
  v
Input the array
  |
  v
Set gap = array length / 2
  |
  v
+-------------------------------+
| Is gap > 0 ?                  |
+-------------------------------+
       | Yes                          | No
       v                              v
+-------------------------------+   Done (Array is sorted)
| For i = gap to array.length-1 |
+-------------------------------+
       |
       v
Store array[i] in temp
Set j = i
       |
       v
+---------------------------------------------------+
| While j >= gap AND array[j - gap] > temp         |
+---------------------------------------------------+
       | Yes                          | No
       v                              v
Move array[j - gap] to array[j]      Place temp at array[j]
Set j = j - gap                      (Insert temp in correct position)
       |
       v
Repeat inner while loop
       |
       v
Repeat outer for loop for next i
       |
       v
When all i are done for this gap:
Set gap = gap / 2
       |
       v
Repeat outer loop

*/