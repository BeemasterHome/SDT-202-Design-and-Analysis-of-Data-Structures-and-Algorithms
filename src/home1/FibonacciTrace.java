package home1;/*
Programmer: Artem Pasichnyk
Course: SDT 202 Design and Analysis of Data Structures and Algorithms
Due Date: February 10, 2026, 11:59 am
Time Spent: 15 minutes

Description: This program traces a Fibonacci-like sequence using a while loop.
It calculates values for a and b until b reaches 20, then prints the result.
AI Tool Statement: This code was refined with the help of Gemini AI
to ensure compliance with the formatting standards of the course.
 */

public class FibonacciTrace {

    public static void main(String[] args) {
        // Part 3. Trace the Fibonacci-like Loop
        runFibonacciTrace();
    }

    /*
     * Executes the loop logic and prints the final values of a and b.
     */
    public static void runFibonacciTrace() {
        int a = 1;
        int b = 1;
        int step = 0;

        System.out.println("Start a = " + a + ", b = " + b);
        System.out.println("=================");

        while (b < 20) {
            step++;
            b = a + b;
            a = b - a;
            System.out.println("Step " + step + ": a = " + a + ", b = " + b);
            System.out.println("==================");
        }

        System.out.print("Final result: ");
        System.out.println(a + ", " + b);
    }
}