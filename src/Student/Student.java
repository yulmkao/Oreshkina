package Student;

public class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        if (gpa < 0) {
            this.gpa = 0;
        } else if (gpa > 100) {
            this.gpa = 100;
        } else {
            this.gpa = gpa;
        }
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}
