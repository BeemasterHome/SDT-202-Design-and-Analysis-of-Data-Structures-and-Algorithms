package home2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Item[] q;
    private int n;
    private int first;
    private int last;

    public Queue() {
        q = (Item[]) new Object[2]; // Початковий розмір
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last = n;
    }

    public void enqueue(Item item) {
        if (n == q.length) resize(2 * q.length);
        q[last++] = item;
        if (last == q.length) last = 0;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;
        n--;
        first++;
        if (first == q.length) first = 0;
        if (n > 0 && n == q.length / 4) resize(q.length / 2);
        return item;
    }

    public Iterator<Item> iterator() { return new QueueIterator(); }

    private class QueueIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() { return i < n; }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return q[(i++ + first) % q.length];
        }
    }
}