class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;
    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4 || monthlyFee <= 0) throw new IllegalArgumentException();
        this.memberId=memberId; this.monthlyFee=monthlyFee;
    }
    public void attendSession() { sessionsAttended++; }
    public int getSessionsAttended() { return sessionsAttended; }
}

class PremiumMember extends GymMember {
    private String trainerName;
    public PremiumMember(String memberId, int monthlyFee, String trainerName) { super(memberId, monthlyFee); this.trainerName=trainerName; }
    public String getTrainerName() { return trainerName; }
}

class SignUp {
    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp=0, rejected=0;
        for(String id:memberIds) { try { new GymMember(id,monthlyFee); signedUp++; } catch(IllegalArgumentException e){ rejected++; } }
        return "Signed Up: "+signedUp+" | Rejected: "+rejected;
    }
}

public class GymMembershipFoundation {
    public static void main(String[] args) {
        System.out.println("Program ready");
    }
}