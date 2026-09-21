class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    private boolean membershipIdSet;

    public LibraryMember() { }

    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String id) {
        if (!membershipIdSet) {
            membershipId = id;
            membershipIdSet = true;
        }
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean premium) { premiumMember = premium; }
    public void setSecurityAnswer(String answer) {
        securityAnswer = answer == null ? null : Integer.toHexString(answer.hashCode());
    }
}

public class LibraryMemberJavaBean {
    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setMembershipId("FAKE-0000");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        m.setSecurityAnswer("BlueMountain");
        System.out.println(m.getMembershipId());
        System.out.println(m.isPremiumMember());
    }
}