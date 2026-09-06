import java.util.Scanner;

class SeatChecker {
    void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
            if (foundDuplicate) {
                break;
            }
        }
        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
	
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Number of seats: ");
        int totalSeats = scanner.nextInt();
        int[] seats = new int[totalSeats];
		System.out.println("Enter seat numbers: ");
        for (int i = 0; i < totalSeats; i++) {
            seats[i] = scanner.nextInt();
        }

        SeatChecker checker = new SeatChecker();
        checker.checkDuplicateSeats(seats);
    }
}
