class Enrollment {
    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0, rejected = 0;
        for (String id : memberIds) {
            try { new LibraryMember(id, borrowLimit); enrolled++; }
            catch (IllegalArgumentException e) { rejected++; }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }
}

class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) throw new IllegalArgumentException();
        if (borrowLimit <= 0) throw new IllegalArgumentException();
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) booksBorrowed++;
    }

    public int getBooksBorrowed() { return booksBorrowed; }
    public String displayInfo() { return "General Member | Books Borrowed: " + booksBorrowed; }
}

class StudentMember extends LibraryMember {
    private String course;
    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
    public String getCourse() { return course; }
    @Override
    public String displayInfo() { return "Student Member | Course: " + course + " | Books Borrowed: " + booksBorrowed; }
}

public class LibraryMembershipFoundation {
    public static void main(String[] args) {
        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(Enrollment.enrollBatch(ids, 3));
    }
}