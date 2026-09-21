class GroupClassMember extends GymMember {
    private String className;
    public GroupClassMember(int monthlyFee,String className){super(monthlyFee);this.className=className;}
}

class GymMember {
    private static int membersEnrolled;
    public final int membershipNumber;
    protected int monthlyFee;
    private int feesPaid;
    public GymMember(int monthlyFee){this.monthlyFee=monthlyFee;membersEnrolled++;membershipNumber=membersEnrolled;}
    public void payFee(int amount){feesPaid+=amount;}
    public void payFee(int amount,String mode){payFee(amount);}
    public int getFeesPaid(){return feesPaid;}
    public static boolean isValidReferralCode(String code){
        if(code==null||code.length()!=4)return false;
        return code.charAt(0)=='G'&&Character.isDigit(code.charAt(1))&&Character.isDigit(code.charAt(2))&&Character.isUpperCase(code.charAt(3));
    }
    public static int getMembersEnrolled(){return membersEnrolled;}
}

class WeeklyCheckIn {
    public static String processWeeklyCheckIn(GymMember[] members){
        int processed=0,nullSkipped=0,group=0,individual=0;
        for(GymMember member:members){
            if(member==null)nullSkipped++;
            else{processed++;if(member instanceof GroupClassMember)group++;else individual++;}
        }
        return processed+" processed | "+nullSkipped+" null skipped | "+group+" group | "+individual+" individual";
    }
}

public class MembershipNumbersReferralCodes {
    public static void main(String[] args) {
        System.out.println("Program ready");
    }
}