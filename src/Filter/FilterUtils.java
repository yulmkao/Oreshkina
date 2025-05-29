package Filter;

import java.util.List;
import java.util.ArrayList;

public class FilterUtils {

    public static Predicate createFilter(List<Integer> numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        double average = (double) sum / numbers.size();

        return new Predicate() {
            @Override
            public boolean predicate(int value) {
                return value > average;
            }
        };
    }
    public static List<Integer> filterList(List<Integer> list, Predicate predicate) {
        List<Integer> result = new ArrayList<>();
        for (int n : list) {
            if (predicate.predicate(n)) {
                result.add(n);
            }
        }
        return result;
    }
}
