package University;

import java.util.Comparator;

public class StudentComparators {
    public static Comparator<Students> byGradeDesc = (student1, student2) ->
            Integer.compare(student2.getAverageGrade(), student1.getAverageGrade());

    public static Comparator<Students> byName = (student1, student2) ->
            student1.getFullName().compareToIgnoreCase(student2.getFullName());
}