package University;

public class Students implements Comparable<Students> {

    private String fullName;
    private int age;
    private int averageGrade;

    public Students(String fullName, int age, int averageGrade) {
        this.fullName = fullName;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return String.format("Student{fullName='%s', age=%d, averageGrade=%.1f}",
                fullName, age, (float) averageGrade);
    }

    @Override
    public int compareTo(Students other) {
        return Integer.compare(this.age, other.age);
    }
}
