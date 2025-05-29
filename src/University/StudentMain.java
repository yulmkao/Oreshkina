package University;

public class StudentMain {
    public static void main(String[] args) {
        ManageStudents manage = new ManageStudents();
        manage.addStudent(new Students("Иван Иванов", 20, 80));
        manage.addStudent(new Students("Петя Петров", 22, 55));
        manage.addStudent(new Students("Егор Егоров", 19, 95));
        manage.addStudent(new Students("Андрей Андреев", 21, 40));
        System.out.println("все студенты:");
        manage.printAll();
        System.out.println("сортируем по имени:");
        manage.sortByName();
        manage.printAll();
        System.out.println("сортируем по среднему баллу;");
        manage.sortByGradeDesc();
        manage.printAll();
        System.out.println("отчисляем двоечников, оставляем молодцов:");
        manage.removeFailingStudents();
        manage.printAll();
        System.out.println();
        for (Students student : manage.getStudentsOlderThan(20)) {
            System.out.println(student);
        }
        System.out.println("молодцы:");
        for (Students student : manage.getTopStudents(70)) {
            System.out.println(student);
        }
    }
}