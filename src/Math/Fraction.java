package Math;

public class Fraction extends Number {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cant be zero");
        }
        reduce();
    }

    public void reduce() {
        int divisor = findDivisor(numerator, denominator);
        numerator /= divisor;
        denominator /= divisor;
    }

    private int findDivisor(int a, int b) {
        return b == 0 ? a : findDivisor(b, a % b);
    }

    public Fraction add(Fraction other) {
        int newNumerator = numerator * other.denominator
                + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = numerator * other.denominator
                - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.numerator,
                denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("cant divide by zero");
        }
        return new Fraction(numerator * other.denominator,
                denominator * other.numerator);
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long)numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float)numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double)numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
