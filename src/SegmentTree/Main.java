package SegmentTree;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("тестирование SegmentTree\n");
        Random random = new Random();
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        SegmentTree tree = new SegmentTree(new int[10000]);

        List<Long> updateTimes = new ArrayList<>();
        List<Integer> updateOperations = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            long start = System.nanoTime();
            tree.update(i, array[i]);
            long end = System.nanoTime();
            updateTimes.add(end - start);
            updateOperations.add(tree.operations);
        }

        List<Long> searchSumTimes = new ArrayList<>();
        List<Integer> searchSumOperations = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(9990);
            long start = System.nanoTime();
            tree.searchSum(index, index + 10);
            long end = System.nanoTime();
            searchSumTimes.add(end - start);
            searchSumOperations.add(tree.operations);
        }

        List<Long> removeTimes = new ArrayList<>();
        List<Integer> removeOperations = new ArrayList<>();

        Set<Integer> removed = new HashSet<>();
        while (removed.size() < 1000) {
            int index = random.nextInt(10000);
            if (!removed.contains(index)) {
                removed.add(index);
                long start = System.nanoTime();
                tree.remove(index);
                long end = System.nanoTime();
                removeTimes.add(end - start);
                removeOperations.add(tree.operations);
            }
        }

        writeToFile("update_results.txt", updateOperations, updateTimes);
        writeToFile("searchsum_results.txt", searchSumOperations, searchSumTimes);
        writeToFile("remove_results.txt", removeOperations, removeTimes);

        System.out.println("\nитоги:");
        System.out.println("среднее время добавления(мкс): " + averageLong(updateTimes) / 1000.0);
        System.out.println("среднее количество операций добавления: " + averageInt(updateOperations));
        System.out.println("среднее время поиска суммы(мкс): " + averageLong(searchSumTimes) / 1000.0);
        System.out.println("среднее количество операций поиска суммы: " + averageInt(searchSumOperations));
        System.out.println("среднее время удаления(мкс): " + averageLong(removeTimes) / 1000.0);
        System.out.println("среднее количество операций удаления: " + averageInt(removeOperations));
    }

    static void writeToFile(String filename, List<Integer> operations, List<Long> times) throws IOException {
        try (FileWriter fw = new FileWriter(filename)) {
            for (int i = 0; i < operations.size(); i++) {
                fw.write(operations.get(i) + " " + times.get(i) + "\n");
            }
        }
    }

    static double averageInt(List<Integer> list) {
        long sum = 0;
        for (int v : list) sum += v;
        return sum * 1.0 / list.size();
    }

    static double averageLong(List<Long> list) {
        long sum = 0;
        for (long v : list) sum += v;
        return sum * 1.0 / list.size();
    }
}
