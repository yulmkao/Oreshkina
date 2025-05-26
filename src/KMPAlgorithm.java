import java.io.*;
import java.util.*;

public class KMPAlgorithm {

    private static int iterations;

    public static void main(String[] args) throws IOException {
        int testCount = 50;
        int minSize = 100;
        int maxSize = 10000;
        generateTestData("testdata.txt", testCount, minSize, maxSize);
        BufferedReader reader = new BufferedReader(new FileReader("testdata.txt"));
        System.out.println("Test | TextSize | PatternSize | Time(ns) | Iterations");
        System.out.println("-----------------------------------------------------");
        for (int i = 1; i <= testCount; i++) {
            String text = reader.readLine();
            String pattern = reader.readLine();
            iterations = 0;
            long startTime = System.nanoTime();
            int position = kmpSearch(text, pattern);
            long endTime = System.nanoTime();
            long time = endTime - startTime;
            System.out.printf("%4d | %8d | %11d | %8d | %10d\n", i, text.length(), pattern.length(), time, iterations);
        }
        reader.close();
    }

    private static void generateTestData(String file, int count, int minSize, int maxSize) throws IOException {
        Random random = new Random();
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < count; i++) {
            int textLength = minSize + random.nextInt(maxSize - minSize + 1);
            String text = generateRandomString(textLength);
            int maxPatternLength = Math.min(50, textLength);
            int patternLength = 5 + random.nextInt(maxPatternLength - 4);
            int start = random.nextInt(textLength - patternLength + 1);
            String pattern = text.substring(start, start + patternLength);
            writer.println(text);
            writer.println(pattern);
        }
        writer.close();
    }

    public static int[] prefixFunction(String pattern) {
        int[] table = new int[pattern.length()];
        for (int i = 1; i < pattern.length(); i++) {
            int j = table[i - 1];
            iterations++;
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
                iterations++;
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }

    public static int kmpSearch(String text, String pattern) {
        int[] table = prefixFunction(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            iterations++;
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                iterations++;
                j = table[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                iterations++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static String generateRandomString(int length) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(letters.charAt(r.nextInt(letters.length())));
        }
        return result.toString();
    }
}