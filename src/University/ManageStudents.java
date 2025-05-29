package University;

import java.util.*;

public class ManageStudents {
    private List<Students> students = new ArrayList<>();

    public void addStudent(Students student) {
        students.add(student);
    }

    public void removeFailingStudents() {
        Iterator<Students> bye = students.iterator();
        while (bye.hasNext()) {
            if (bye.next().getAverageGrade() < 56) {
                bye.remove();
            }
        }
    }

    public List<Students> getStudentsOlderThan(int age) {
        List<Students> result = new ArrayList<>();
        for (Students student : students) {
            if (student.getAge() > age) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Students> getTopStudents(double minGrade) {
        List<Students> result = new ArrayList<>();
        for (Students student : students) {
            if (student.getAverageGrade() >= minGrade) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortByAge() {
        Collections.sort(students); // Comparable
    }

    public void sortByGradeDesc() {
        students.sort(StudentComparators.byGradeDesc);
    }

    public void sortByName() {
        students.sort(StudentComparators.byName);
    }

    public void printAll() {
        for (Students student : students) {
            System.out.println(student);
        }
    }
}