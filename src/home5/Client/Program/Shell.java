package home5.Client.Program;

/**
 * Modified Shellsort algorithm for SDT 202 Homework 5.
 *  * Course:       SDT 202 Design and Analysis of Data Structures and Algorithms
 *  * Assignment:   Homework 5, Part 2
 *  * Date:         March 10, 2026
 *  *
 *  * Description:  This class implements a modified Shellsort algorithm (Algorithm 2.3).
 *  * It calculates and stores the increment sequence in an array
 *  * prior to sorting, rather than computing it dynamically on the fly.
 *  *
 *  * Time spent: 2 hours
 */

public class Shell {
    public static void sort(Comparable[] a) {
        int n = a.length;

        // Step 1: Count how many increments we need
        int count = 0;
        int tempH = 1;
        while (tempH < n/3) {
            tempH = 3 * tempH + 1;
            count++;
        }

        // Step 2: Keep the increment sequence in an array
        int[] increments = new int[count + 1];
        int h = 1;
        for (int i = 0; i <= count; i++) {
            increments[i] = h;
            h = 3 * h + 1;
        }

        for (int i = increments.length - 1; i >= 0; i--) {
            int currentH = increments[i]; // Use h from the array
            for (int j = currentH; j < n; j++) {
                for (int k = j; k >= currentH && less(a[k], a[k-currentH]); k -= currentH) {
                    exch(a, k, k-currentH);
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
}