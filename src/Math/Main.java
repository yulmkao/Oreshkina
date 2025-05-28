package Math;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);

        System.out.println("fraction add: " + f1.add(f2));
        System.out.println("fraction sub: " + f1.subtract(f2));
        System.out.println("fraction mul: " + f1.multiply(f2));
        System.out.println("fraction div: " + f1.divide(f2));

        Calculator<Integer> intCalc = new Calculator<>(Integer.class);
        System.out.println("Integer Add: " + intCalc.add(10, 5));

        Calculator<Double> doubleCalc = new Calculator<>(Double.class);
        System.out.println("Double Div: " + doubleCalc.divide(7.5, 2.5));
    }
}
