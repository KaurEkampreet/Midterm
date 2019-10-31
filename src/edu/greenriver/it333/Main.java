package edu.greenriver.it333;

public class Main {

    public static void main(String[] args) {
         testRationalDivide();
        // testRationalSquare();
         testStackPeek();
         testStequeEnqueue();
         testDequeIterator();
    }

    public static void testRationalDivide() {
        Rational r = new Rational(3, 4);
        Rational s = r.dividedBy(new Rational(1, 8));

        System.out.println("--- Begin Test Rational Divide ---");
        // result should be 24/4 == 6
        System.out.println(s);
        System.out.println("--- End Test Rational Divide ---");
    }

    public static void testRationalSquare() {
        Rational r = new Rational(3, 4);
        Rational s = r.square();

        System.out.println("--- Begin Test Rational Square ---");
        // result should be 9/16
        System.out.println(s);
        System.out.println("--- End Test Rational Square ---");
    }

    public static void testStackPeek() {
        Stack<String> stack = new Stack<String>();
        stack.push("alpha");
        stack.push("bravo");
        stack.push("charlie");
        stack.push("delta");
        stack.push("echo");
        stack.push("foxtrot");
        stack.push("golf");

        System.out.println("--- Begin Test Stack Peek ---");

        // you should see "golf"
        System.out.println(stack.peek());

        System.out.println("--- End Test Stack Peek ---");
    }

    public static void testStequeEnqueue() {
        Steque<String> steque = new Steque<String>();
        steque.push("alpha");
        steque.push("bravo");
        steque.push("charlie");

        steque.enqueue("delta");
        steque.enqueue("echo");
        steque.enqueue("foxtrot");

        System.out.println("--- Begin Test Steque Enqueue ---");

        // You should see:
        // C B A D E F

        for (String s : steque) {
            System.out.println(s);
        }

        System.out.println("--- End Test Stack Peek ---");
    }


    public static void testDequeIterator() {
        Deque<String> deque = new Deque<String>();
        deque.pushRight("alpha");
        deque.pushRight("bravo");
        deque.pushRight("charlie");
        deque.pushRight("delta");
        deque.pushRight("echo");
        deque.pushRight("foxtrot");
        deque.pushRight("golf");

        System.out.println("--- Begin Test Deque Iterator ---");

        // You should see a printout of the deque
        // going from alpha through foxtrot
        // a blank line, then
        // going from foxtrot through alpha

        // Retrieve an iterator from the deque
        TwoWayIterator<String> itr = deque.iterator();

        // The iterator should start at beginning/leftmost position

        // Walk forwards/right and print out along the way
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // At this point, we are at the end/rightmost

        System.out.println();

        // Walk backwards/left and print out along the way
        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }

        // At this point, we are at the beginning/leftmost

        System.out.println("--- End Test Deque Iterator ---");
    }

}
