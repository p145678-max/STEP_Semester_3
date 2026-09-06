class RecordDetails {
    String studentName;
    String company;
    double packageLpa;

    RecordDetails(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class PlacementRecord {
    public static void main(String[] args) {
        RecordDetails[] records = {
            new RecordDetails("Ravi", "TCS", 4.5),
            new RecordDetails("Anitha", "Zoho", 6.2),
            new RecordDetails("Karthik", "Infosys", 4.0)
        };

        for (RecordDetails record : records) {
            record.printRecord();
        }
    }
}
