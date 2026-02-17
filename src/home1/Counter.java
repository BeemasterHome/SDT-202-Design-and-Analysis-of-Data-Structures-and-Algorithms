package home1;

/*
 Programmer: Artem Pasichnyk
 Course: SDT 202 Design and Analysis of Data Structures and Algorithms
 Due Date: February 10, 2026, 11:59 pm
 Time Spent: 20 minutes
 Description: Design and implementation of a Counter ADT.
 This class provides operations to increment and retrieve a value.
 */
class CounterClient {
    public static class Counter{
        private int count;

        /*
         Initializes the counter with zero.
         */
        public Counter() {
            count = 0;
        }

        /*
         Increments the internal counter by one.
         */
        public void increment() {
            count++;
        }

        /*
         Returns the current value of the counter.
         */
        public int value() {
            return count;
        }

        /*
         Returns a string representation of the counter.
         */
        @Override
        public String toString() {
            return "Counter value: " + count;
        }


    }
    public static void main(String[] args) {
        // Part 1. Counter ADT Client
        testCounter();
    }

    /*
     Demonstrates the behavior of the Counter ADT.
     */
    public static void testCounter() {
        Counter myCounter = new Counter();

        myCounter.increment();
        myCounter.increment();

        System.out.println(myCounter.toString());
    }
}

