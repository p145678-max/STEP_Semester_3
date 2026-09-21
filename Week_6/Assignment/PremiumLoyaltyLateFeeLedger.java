class GymMember {
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount;
    protected String memberId; protected int monthlyFee;
    public GymMember(String memberId,int monthlyFee){this.memberId=memberId;this.monthlyFee=monthlyFee;}
    protected void chargeLateFee(int amount){if(lateFeeCount<lateFeeHistory.length)lateFeeHistory[lateFeeCount++]=amount;}
    public int[] getLateFeeHistory(){int[] copy=new int[lateFeeCount];for(int i=0;i<lateFeeCount;i++)copy[i]=lateFeeHistory[i];return copy;}
    public int getTotalLateFees(){int total=0;for(int i=0;i<lateFeeCount;i++)total+=lateFeeHistory[i];return total;}
}

class PremiumMember extends GymMember {
    public PremiumMember(String memberId,int monthlyFee,String trainerName){super(memberId,monthlyFee);}
    @Override protected void chargeLateFee(int amount){super.chargeLateFee(amount/2);}
}

public class PremiumLoyaltyLateFeeLedger {
    public static void main(String[] args) {
        System.out.println("Program ready");
    }
}