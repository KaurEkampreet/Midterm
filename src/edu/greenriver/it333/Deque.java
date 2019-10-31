package edu.greenriver.it333;

import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    // fields for the Deque class
    private int n;        // number of elements on list
    private Node pre;     // sentinel before first item
    private Node post;    // sentinel after last item
    private int itrModCount;

    // linked list node helper data type
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public Deque() {
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
        n = 0;

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void pushLeft(Item item) {
        Node first = pre.next;

        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = pre;
        newNode.next = first;

        pre.next = newNode;
        first.prev = newNode;
        n++;
    }

    public void pushRight(Item item) {
        Node last = post.prev;

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = post;
        newNode.prev = last;

        post.prev = newNode;
        last.next = newNode;
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("deque is empty");
        }

        Node first = pre.next;
        Item item = first.item;

        first.next.prev = pre;
        pre.next = first.next;
        n--;

        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("deque is empty");
        }

        Node last = post.prev;
        Item item = last.item;

        last.prev.next = post;
        post.prev = last.prev;
        n--;

        return item;
    }

    @Override
    public TwoWayIterator<Item> iterator() {
        // remove the exception, complete the method
        return new DequeIterator(itrModCount);
    }

    private class DequeIterator implements TwoWayIterator<Item> {
        // --- fields --------------------
        // ???
        private Node current;
        private int modcount;

        // --- methods -------------------
        public DequeIterator(int itrModCount) {
            current = pre.next;
           // modcount = itrModCount;
        }


        @Override
        public boolean hasNext() {
            if (current != post) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item temp = current.item;
            current = current.next;
            return temp;
        }

        @Override
        public boolean hasPrevious() {
            if (current != pre.next) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Item previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current = current.prev;
            return current.item;
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            }

            StringBuilder sb = new StringBuilder();

            sb.append("[");

            Node current = pre.next;
            Node last = post.prev;

            while (current != last) {
                sb.append(current.item);
                sb.append(",");
                current = current.next;
            }

            sb.append(last.item);
            sb.append("]");

            return sb.toString();
        }
    }
}
