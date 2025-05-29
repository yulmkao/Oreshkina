package Filter;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 10, 15, 20, 25);
        Predicate predicate = FilterUtils.createFilter(numbers);
        List<Integer> filtered = FilterUtils.filterList(numbers, predicate);

        System.out.println("исходный список: " + numbers);
        System.out.println("числа больше среднего: " + filtered);
    }
}
