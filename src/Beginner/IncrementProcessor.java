package Beginner;

import java.util.ArrayList;
import java.util.List;

class IncrementProcessor implements ListProcessor {

    @Override
    public List<Integer> process(List<Integer> input) {
        List<Integer> result = new ArrayList<>();
        for (int num : input) {
            result.add(num + 1);
        }
        return result;
    }
}