class CollegeStudent {
    static String collegeName;
    static String academicYear;

    String studentName;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }

    CollegeStudent(String studentName) {
        this.studentName = studentName;
    }

    void printConfirmation() {
        System.out.println("Student registered: " + studentName);
    }
}

public class CollegeStudentRegistration {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : names) {
            CollegeStudent student = new CollegeStudent(name);
            student.printConfirmation();
        }
    }
}
