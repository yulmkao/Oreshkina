package Beginner;

import java.util.List;
import java.util.ArrayList;

class FilterPositiveProcessor implements ListProcessor {

    @Override
    public List<Integer> process(List<Integer> input) {
        List<Integer> result = new ArrayList<>();
        for (int num : input) {
            if (num > 0) {
                result.add(num);
            }
        }
        return result;
    }
}