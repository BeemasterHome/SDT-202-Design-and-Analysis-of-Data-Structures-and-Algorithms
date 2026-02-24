package home3;
import java.util.NoSuchElementException;
/**
 * Programmer: Pasichnyk Artem
 * Course: SDT 202 Design and Analysis of Data Structures and Algorithms
 * Due Date: Tuesday, February 24, 2026 [cite: 277]
 * Time Spent: 2 hours
 */
public class SortingAnalysis {

    public static long selectionSort(int[] arr) {
        long startTime = System.nanoTime();
        long count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                count++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        long endTime = System.nanoTime();
        System.out.println("Selection Sort Execution Time: " + (endTime - startTime) + " ns");
        return count;
    }

    public static long insertionSort(int[] arr) {
        long startTime = System.nanoTime();
        long count = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                count++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                } else break;
            }
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        System.out.println("Insertion Sort Execution Time: " + (endTime - startTime) + " ns");
        return count;
    }

    public static long bubbleSort(int[] arr) {
        long startTime = System.nanoTime();
        long count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Execution Time: " + (endTime - startTime) + " ns");
        return count;
    }
}