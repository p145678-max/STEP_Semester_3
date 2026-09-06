class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicket {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 101);
        HallTicket copy = priya;

        copy.seatNumber = 205;

        System.out.println("Priya seat number: " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 205);
        System.out.println("separate == priya: " + (separate == priya));
    }
}
