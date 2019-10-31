package edu.greenriver.it333;

public class Rational {

    // fields
    private long numerator;
    private long denominator;

    // create and initialize a new Rational object
    // will reduce the rational/fraction upon initializing
    public Rational(long numerator, long denominator) {

        // deal with x/0
        if (denominator == 0) {
            throw new ArithmeticException("denominator cannot be zero");
        }

        // reduce fraction
        long g = gcd(numerator, denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;

        // if the denominator is negative,
        // then move the negative up to the numerator
        if (this.denominator < 0) {
            this.denominator = -this.denominator;
            this.numerator = -this.numerator;
        }
    }

    // adds 'this' and b, returns the result as a new Rational object
    public Rational plus(Rational b) {

        long newNumerator =
                this.numerator * b.denominator +
                        this.denominator * b.numerator;

        long newDenominator = this.denominator * b.denominator;

        // I don't have to worry about a common denominator
        // above, because when I create a Rational below,
        // it will reduce the fraction in the constructor code.

        return new Rational(newNumerator, newDenominator);
    }

    // helper method for minus
    // returns the negative of 'this' as a new Rational object
    private Rational opposite() {
        return new Rational(-numerator, denominator);
    }

    // returns a new Rational object with the result of 'this' minus b
    public Rational minus(Rational b) {
        return plus(b.opposite());
    }

    // multiplies 'this' times b, returns the result as a new Rational object
    public Rational times(Rational b) {
        long newNumerator = numerator * b.numerator;
        long newDenominator = denominator * b.denominator;

        return new Rational(newNumerator, newDenominator);
    }

    // returns a Rational object that is the reciprocal of 'this'
    private Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    // returns a Rational object with the result of 'this' divided by b
    public Rational dividedBy(Rational b) {
        return this.times(b.reciprocal());
    }

    // returns a Rational object that is the square of 'this'
    public Rational square() {
        // remove the exception and replace with your code
        throw new UnsupportedOperationException();
    }

    // is this Rational object equal to other?
    @Override
    public boolean equals(Object that) {
        if (that instanceof Rational) {
            // 'that' is a Rational, so we can safely cast it
            Rational other = (Rational)that;

            // cross-multiply to check if they are equal
            long a = this.denominator * other.numerator;
            long b = other.denominator * this.numerator;

            return a == b;
        }
        else {
            // 'that' is not a Rational
            return false;
        }
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return Long.toString(numerator);
        }
        else {
            return numerator + "/" + denominator;
        }
    }

    // helper method to calculate greatest common divisor
    private static long gcd(long p, long q) {
        // if either p or q are negative
        // make them positive to make things easier
        if (p < 0) {
            p = -p;
        }

        if (q < 0) {
            q = -q;
        }

        // Euclid's algorithm from p. 4
        if (q == 0) {
            return p;
        }
        else {
            long r = p % q;
            return gcd(q, r);
        }
    }
}
