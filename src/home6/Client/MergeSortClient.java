package home6.Client;

import home6.bottom.BottomUpMergeSort;
import home6.top.TopDownMergeSort;

import java.util.Random;

public class MergeSortClient {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000}; // Розміри вхідних даних

        System.out.println("Size\tTop-Down (ms)\tBottom-Up (ms)");

        for (int n : sizes) {
            Integer[] a = generateRandomArray(n);
            Integer[] b = a.clone();

            // Вимірювання Top-Down
            long startTD = System.nanoTime();
            TopDownMergeSort.sort(a);
            long endTD = System.nanoTime();
            double timeTD = (endTD - startTD) / 1000000.0;

            // Вимірювання Bottom-Up
            long startBU = System.nanoTime();
            BottomUpMergeSort.sort(b);
            long endBU = System.nanoTime();
            double timeBU = (endBU - startBU) / 1000000.0;

            System.out.printf("%d\t%.3f\t\t%.3f\n", n, timeTD, timeBU);
        }
    }

    private static Integer[] generateRandomArray(int n) {
        Random rd = new Random();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = rd.nextInt(n * 10);
        return a;
    }
}
