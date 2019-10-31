package edu.greenriver.it333;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<Item> implements Iterable<Item> {
    private Node first;     // top of stack (most recently added node)
    private int n;          // number of items, size of the stack

    // linked list node helper class
    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    public Item peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }
      Item item = first.item;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Item item : this) {
            sb.append(item);
            sb.append(" ");
        }

        return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = current.item;   // save item to return
            current = current.next;     // advance current to the next node
            return item;                // return the saved item
        }
    }
}

