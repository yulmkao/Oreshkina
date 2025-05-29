package Beginner;

import  java.util.List;

public class ListProcessorUtils {
    public static List<Integer> applyProcessor(ListProcessor p, List<Integer> list) {
        return p.process(list);
    }

    public static ListProcessor composeProcessors(ListProcessor f, ListProcessor g) {
        return input -> f.process(g.process(input));
    }
}