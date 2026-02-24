package home3;

import java.util.Random;
import java.util.Arrays;

public class SortingDriver {
    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000};
        Random random = new Random();

        for (int size : sizes) {
            System.out.println("\n--- Testing Array Size: " + size + " ---");

            int[] original = new int[size];
            for (int i = 0; i < size; i++) {
                original[i] = random.nextInt(10000);
            }

            int[] selectionArr = Arrays.copyOf(original, original.length);
            int[] insertionArr = Arrays.copyOf(original, original.length);
            int[] bubbleArr = Arrays.copyOf(original, original.length);

            long selCount = SortingAnalysis.selectionSort(selectionArr);
            System.out.println("Selection Sort Comparisons: " + selCount);

            long insCount = SortingAnalysis.insertionSort(insertionArr);
            System.out.println("Insertion Sort Comparisons: " + insCount);

            long bubCount = SortingAnalysis.bubbleSort(bubbleArr);
            System.out.println("Bubble Sort Comparisons: " + bubCount);
        }
    }
}