package Beginner;

import java.util.List;
import java.util.ArrayList;

class SquareProcessor implements ListProcessor {

    @Override
    public List<Integer> process(List<Integer> input) {
        List<Integer> result = new ArrayList<>();
        for (int num : input) {
            result.add(num * num);
        }
        return result;
    }
}