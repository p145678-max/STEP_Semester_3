class Student {
    String name;
    int attendance;

    static String collegeName;
    static int studentCount;

    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Student Count: " + studentCount);
    }
}

public class CollegeStudent {
    public static void main(String[] args) {
        Student.collegeName = "SRM Institute of Science and Technology";

        Student student1 = new Student("Ravi", 90);
        Student student2 = new Student("Meera", 95);

        Student.printCollegeInfo();
    }
}
