package Math;

public class Calculator<T extends Number> {

    private final Class<T> type;

    public Calculator(Class<T> type) {
        this.type = type;
    }

    public T add(T a, T b) {
        double result = a.doubleValue() + b.doubleValue();
        return castToT(result);
    }

    public T subtract(T a, T b) {
        double result = a.doubleValue() - b.doubleValue();
        return castToT(result);
    }

    public T multiply(T a, T b) {
        double result = a.doubleValue() * b.doubleValue();
        return castToT(result);
    }

    public T divide(T a, T b) {
        if (b.doubleValue() == 0.0) {
            throw new IllegalArgumentException("cant divide by zero");
        }
        double result = a.doubleValue() / b.doubleValue();
        return castToT(result);
    }

    @SuppressWarnings("unchecked")
    private T castToT(double value) {
        return (T) Double.valueOf(value);
    }
}