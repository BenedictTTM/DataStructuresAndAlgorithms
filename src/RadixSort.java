import java.util.*;

public class RadixSort {

    // Get maximum number of digits in the array
    public static int getMaxDigits(int[] arr) {
        int max = Arrays.stream(arr).map(Math::abs).max().orElse(0);
        return String.valueOf(max).length();
    }

    // Get the digit at a specific position
    public static int getDigit(int number, int position) {
        return (Math.abs(number) / position) % 10;
    }

    // Radix sort algorithm
    public static void radixSort(int[] arr) {
        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) buckets[i] = new ArrayList<>();

        int maxDigits = getMaxDigits(arr);
        int pow10 = 1;

        for (int digitIndex = 0; digitIndex < maxDigits; digitIndex++) {
            for (int value : arr) {
                int bucketIndex = getDigit(value, pow10);
                buckets[bucketIndex].add(value);
            }

            int arrayIndex = 0;
            for (List<Integer> bucket : buckets) {
                for (int num : bucket) {
                    arr[arrayIndex++] = num;
                }
                bucket.clear(); // clear for next pass
            }

            pow10 *= 10;
        }
    }

    // Main sorting logic to handle both negatives and non-negatives
    public static void sort(int[] arr) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> nonNegatives = new ArrayList<>();

        for (int num : arr) {
            if (num < 0) negatives.add(num);
            else nonNegatives.add(num);
        }

        int[] negArray = negatives.stream().mapToInt(i -> -i).toArray(); // negate for sorting
        int[] posArray = nonNegatives.stream().mapToInt(i -> i).toArray();

        radixSort(negArray);
        radixSort(posArray);

        // Restore negatives and reverse them
        for (int i = 0; i < negArray.length; i++) {
            arr[i] = -negArray[negArray.length - 1 - i];
        }

        // Append non-negatives
        for (int i = 0; i < posArray.length; i++) {
            arr[negArray.length + i] = posArray[i];
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
                sc.nextLine(); // clear invalid input
            }
        }

        int[] A = new int[n];

        // Input array elements
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
        sort(A);

        // Display after sorting
        System.out.println("\nAfter sorting:");
        printArray(A);
    }
}
