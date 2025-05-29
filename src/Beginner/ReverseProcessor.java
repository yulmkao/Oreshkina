package Beginner;

import java.util.List;
import  java.util.ArrayList;
import  java.util.Collections;

class ReverseProcessor implements ListProcessor {

    @Override
    public List<Integer> process(List<Integer> input) {
        List<Integer> result = new ArrayList<>(input);
        Collections.reverse(result);
        return result;
    }
}
