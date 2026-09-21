class Announcer {
    public static String batchPrint(GymMember[] members){
        StringBuilder result=new StringBuilder();
        for(GymMember member:members){
            result.append(member.displayInfo());
            if(member instanceof PremiumMember){
                PremiumMember premium=(PremiumMember)member;
                result.append(" [Trainer via downcast: ").append(premium.getTrainerName()).append("]");
            }
            result.append(" | ");
        }
        return result.toString();
    }
}

class GymMember {
    protected int sessionsAttended;
    public GymMember(String memberId,int monthlyFee){ }
    public void attendSession(){sessionsAttended++;}
    public int getSessionsAttended(){return sessionsAttended;}
    public String displayInfo(){return "Standard | Sessions: "+sessionsAttended;}
}

class PremiumMember extends GymMember {
    private String trainerName;
    public PremiumMember(String memberId,int monthlyFee,String trainerName){super(memberId,monthlyFee);this.trainerName=trainerName;}
    public String getTrainerName(){return trainerName;}
    @Override public String displayInfo(){return "Premium | Trainer: "+trainerName+" | Sessions: "+sessionsAttended;}
}

public class MonthlyAttendanceAnnouncer {
    public static void main(String[] args) {
        System.out.println("Program ready");
    }
}