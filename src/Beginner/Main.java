package Beginner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int minSize = 10;
        int maxSize = 20;
        int size = random.nextInt(maxSize - minSize + 1) + minSize;

        int minValue = -50;
        int maxValue = 50;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int num = random.nextInt(maxValue - minValue + 1) + minValue;
            numbers.add(num);
        }
        System.out.println("исходный список: " + numbers);
        ListProcessor squareProcessor = new SquareProcessor();
        ListProcessor incrementProcessor = new IncrementProcessor();
        ListProcessor filterPositiveProcessor = new FilterPositiveProcessor();
        ListProcessor reverseProcessor = new ReverseProcessor();
        System.out.println("квадрат элементов: " +
                ListProcessorUtils.applyProcessor(squareProcessor, numbers));
        System.out.println("инкремент элементов: " +
                ListProcessorUtils.applyProcessor(incrementProcessor, numbers));
        System.out.println("только положительные элементы: " +
                ListProcessorUtils.applyProcessor(filterPositiveProcessor, numbers));
        System.out.println("список в обратном порядке: " +
                ListProcessorUtils.applyProcessor(reverseProcessor, numbers));

        ListProcessor composedProcessor = ListProcessorUtils.composeProcessors(
                squareProcessor,
                filterPositiveProcessor
        );

        System.out.println("композиция: " +
                ListProcessorUtils.applyProcessor(composedProcessor, numbers));
    }
}
