package home2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    private Node first; // лівий кінець
    private Node last;  // правий кінець
    private int n;

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }

    public void pushLeft(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst == null) last = first;
        else oldFirst.prev = first;
        n++;
    }

    public void pushRight(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (oldLast == null) first = last;
        else oldLast.next = last;
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        else first.prev = null;
        return item;
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        n--;
        if (isEmpty()) first = null;
        else last.next = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;
            public boolean hasNext() { return current != null; }
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}