class Audit {
    public static String processNightlyAudit(LibraryMember[] members) {
        int processed=0, nullSkipped=0, faculty=0, regular=0;
        for (LibraryMember member: members) {
            if (member==null) nullSkipped++;
            else { processed++; if(member instanceof FacultyMember) faculty++; else regular++; }
        }
        return processed+" processed | "+nullSkipped+" null skipped | "+faculty+" faculty | "+regular+" regular";
    }
}

class FacultyMember extends LibraryMember {
    private String department;
    public FacultyMember(int borrowLimit, String department) { super(borrowLimit); this.department=department; }
}

class LibraryMember {
    private static int membersEnrolled;
    public final int memberNumber;
    protected int borrowLimit;
    protected int booksBorrowed;
    public LibraryMember(int borrowLimit) { this.borrowLimit=borrowLimit; membersEnrolled++; memberNumber=membersEnrolled; }
    public void borrowBook() { if (booksBorrowed < borrowLimit) booksBorrowed++; }
    public void borrowBook(String genre) { borrowBook(); }
    public int getBooksBorrowed() { return booksBorrowed; }
    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length()!=4) return false;
        return code.charAt(0)=='R' && Character.isDigit(code.charAt(1)) && Character.isDigit(code.charAt(2)) && Character.isUpperCase(code.charAt(3));
    }
    public static int getMembersEnrolled() { return membersEnrolled; }
}

public class MembershipNumbersRenewalCodes {
    public static void main(String[] args) {
        System.out.println("Program ready");
    }
}