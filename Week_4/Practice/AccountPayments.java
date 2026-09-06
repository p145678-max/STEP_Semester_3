class FeeAccount {
    void processPayment(double amount) {
        System.out.println("Paid in one go: Rs " + amount);
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    void processPayment(double amount) {
        System.out.println("Paid in two installments: Rs " + amount);
    }
}

public class AccountPayments {
    static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostelAccount = (HostelFeeAccount) account;
            hostelAccount.processPayment(amount);
        } else {
            account.processPayment(amount);
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (FeeAccount account : accounts) {
            processPayment(account, 60000);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel Accounts: " + hostelCount);
        System.out.println("Day Scholar Accounts: " + dayScholarCount);
    }
}
