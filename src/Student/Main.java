package Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("ваня", 75),
                new Student("саша", 85),
                new Student("маша", 60),
                new Student("аня", 90),
                new Student("миша", 70)
        );

        double averageGpa = students.stream()
                .mapToDouble(s -> s.getGpa())
                .average().getAsDouble();;

        Predicate<Student> isAboveAverage = s -> s.getGpa() > averageGpa;

        List<Student> result = students.stream()
                .filter(isAboveAverage)
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .collect(Collectors.toList());

        System.out.println("средний балл: " + averageGpa);
        System.out.println("студенты с баллом выше среднего:");
        for (Student s : result) {
            System.out.println(s);
        }
    }
}