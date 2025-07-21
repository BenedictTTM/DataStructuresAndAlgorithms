package algorithms;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int low = 0; //
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) { // Case where the middle value is the same search key
                return mid;
            } else if (arr[mid] < key) { // Case where middle value < search key
                low = mid + 1; // Discard values to the right of middle value
            } else { // Case where middle value > search key
                high = mid - 1; // Discard values to the left of middle value
            }
        } return -1;
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

        int K = 0;
        // Input search key with validation
        while (true) {
            try {
                System.out.print("Enter value to search for (K): ");
                K = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }

        //Calling the binarySearch method
        int index = binarySearch(A, K);
        if (index == -1) {
            System.out.println("Index: " + index + "❌ Not found.");
        } else {
            System.out.println("✅ Found at index: " + index);
        }
        sc.close();
    }
}

/*
Start
  |
  v
Input sorted array and target value
  |
  v
Set low = 0
Set high = array.length - 1
  |
  v
+--------------------------+
| Is low <= high?         |
+--------------------------+
       | Yes                       | No
       v                           v
Set mid = (low + high) / 2      Print "Target not found"
                                End
       |
       v
+------------------------------+
| Is array[mid] == target?    |
+------------------------------+
       | Yes                       | No
       v                           v
Print "Target found at mid"   +-------------------------------+
End                           | Is target < array[mid]?       |
                              +-------------------------------+
                                     | Yes           | No
                                     v               v
                          Set high = mid - 1   Set low = mid + 1
                                     |
                                     v
                            Go back to: Is low <= high?

*/
