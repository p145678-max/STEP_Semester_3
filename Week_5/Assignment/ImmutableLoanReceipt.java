class CirculationLedger {
    private static String branchCode;

    static {
        branchCode = "PT-01";
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, referenceOnly = 0, regular = 0;
        for (LoanReceipt receipt : receipts) {
            if (receipt == null) nullSkipped++;
            else {
                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) referenceOnly++;
                else regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular";
    }
}

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = new String[bookIds.length];
        for (int i = 0; i < bookIds.length; i++) this.bookIds[i] = bookIds[i];
    }

    public String[] getBookIds() {
        String[] copy = new String[bookIds.length];
        for (int i = 0; i < bookIds.length; i++) copy[i] = bookIds[i];
        return copy;
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] copy = getBookIds();
        copy[index] = newId;
        return new LoanReceipt(memberId, copy);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}

public class ImmutableLoanReceipt {
    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);
        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(r.getBookIds()[1]);
        System.out.println(corrected.getBookIds()[1]);
    }
}