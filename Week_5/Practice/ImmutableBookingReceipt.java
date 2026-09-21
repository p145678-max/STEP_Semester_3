class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = new String[seatNumbers.length];
        for (int i = 0; i < seatNumbers.length; i++) this.seatNumbers[i] = seatNumbers[i];
    }

    public String[] getSeatNumbers() {
        String[] copy = new String[seatNumbers.length];
        for (int i = 0; i < seatNumbers.length; i++) copy[i] = seatNumbers[i];
        return copy;
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] copy = getSeatNumbers();
        copy[index] = newSeat;
        return new BookingReceipt(bookingId, copy);
    }
}

class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}

class Settlement {
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;
        for (BookingReceipt receipt : receipts) {
            if (receipt == null) nullSkipped++;
            else {
                processed++;
                if (receipt instanceof GroupBookingReceipt) group++;
                else individual++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}

public class ImmutableBookingReceipt {
    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]);
        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(b.getSeatNumbers()[1]);
        System.out.println(updated.getSeatNumbers()[1]);
    }
}