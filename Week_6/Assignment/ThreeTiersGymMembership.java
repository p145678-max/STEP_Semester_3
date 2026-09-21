class EliteMember extends PremiumMember {
    private String lockerNumber;
    public EliteMember(String memberId,int monthlyFee,String trainerName,String lockerNumber){super(memberId,monthlyFee,trainerName);this.lockerNumber=lockerNumber;}
    @Override public String displayInfo(){return "Elite Member | Trainer: "+trainerName+" | Locker: "+lockerNumber+" | Sessions: "+sessionsAttended;}
}

class GroupClassMember extends GymMember {
    private String className;
    public GroupClassMember(String memberId,int monthlyFee,String className){super(memberId,monthlyFee);this.className=className;}
    @Override public String displayInfo(){return "Group Class Member | Class: "+className+" | Sessions: "+sessionsAttended;}
}

class GymMember {
    protected String memberId; protected int monthlyFee; protected int sessionsAttended;
    public GymMember(String memberId,int monthlyFee){if(memberId==null||memberId.trim().length()<4||monthlyFee<=0)throw new IllegalArgumentException();this.memberId=memberId;this.monthlyFee=monthlyFee;}
    public void attendSession(){sessionsAttended++;}
    public int getSessionsAttended(){return sessionsAttended;}
    public String displayInfo(){return "Standard Member | Sessions: "+sessionsAttended;}
}

class MembershipTree {
    public static String classifyGeneration(GymMember member){
        if(member instanceof EliteMember)return "Multilevel descendant (3 generations deep)";
        if(member instanceof GroupClassMember)return "Hierarchical sibling (independent branch)";
        if(member instanceof PremiumMember)return "Single-level descendant";
        return "Base member";
    }
    public static int getTotalSessionsAttended(GymMember[] members){int total=0;for(GymMember m:members)total+=m.getSessionsAttended();return total;}
}

class PremiumMember extends GymMember {
    protected String trainerName;
    public PremiumMember(String memberId,int monthlyFee,String trainerName){super(memberId,monthlyFee);this.trainerName=trainerName;}
    public String getTrainerName(){return trainerName;}
    @Override public String displayInfo(){return "Premium Member | Trainer: "+trainerName+" | Sessions: "+sessionsAttended;}
}

public class ThreeTiersGymMembership {
    public static void main(String[] args) {
        System.out.println("Program ready");
    }
}