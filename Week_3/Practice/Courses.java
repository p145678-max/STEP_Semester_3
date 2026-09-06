class CourseDetails {
    String code;
    String title;
    int credits;
    int labCredits;

    CourseDetails(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    CourseDetails(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }
}

public class Courses {
    public static void main(String[] args) {
        CourseDetails course1 = new CourseDetails("CS301", "Java Programming", 3, 1);
        CourseDetails course2 = new CourseDetails("CS302", "Data Structures", 4);

        System.out.println(course1.title + " - Total Credits: " + course1.totalCredits());
        System.out.println(course2.title + " - Total Credits: " + course2.totalCredits());
    }
}
