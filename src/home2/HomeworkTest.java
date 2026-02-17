package home2;

/**
 * Programmer: Pasichnyk Artem
 * Course: SDT 202 Design and Analysis of Data Structures and Algorithms
 * Due Date: Tuesday, February 17, 2026, 11:59 pm
 * Time Spent: 3 hours
 * * Program Description:
 * This program implements two fundamental data structures: a Queue and a Deque.
 * The Queue is implemented using a resizing array that dynamically adjusts its
 * capacity based on the number of elements. The Deque is implemented
 * using a doubly-linked list, allowing efficient additions and removals from
 * both ends. Both classes ensure strict encapsulation by keeping
 * their internal representations private.
 * * AI Tool Statement: AI was used to assist with code structure and
 * report formatting. All logic was reviewed and tested for accuracy.
 */

public class HomeworkTest {
    public static void main(String[] args) {

        Queue<String> q = new Queue<>();
        q.enqueue("First");
        q.enqueue("Second");
        System.out.println("Queue size: " + q.size());

        Deque<Integer> d = new Deque<>();
        d.pushLeft(10);
        d.pushRight(20);
        System.out.println("Deque popLeft: " + d.popLeft());
    }
}
