class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private")) return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("default")) return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("protected")) return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("public")) return "ALLOWED";
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[4];
        int[] denied = new int[4];
        for (String[] attempt : attempts) {
            for (int i = 0; i < modifiers.length; i++) {
                if (attempt[0].equals(modifiers[i])) {
                    if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) allowed[i]++;
                    else denied[i]++;
                }
            }
        }
        String result = "";
        for (int i = 0; i < modifiers.length; i++) {
            result += modifiers[i] + ": " + allowed[i] + " allowed / " + denied[i] + " denied";
            if (i < modifiers.length - 1) result += " | ";
        }
        return result;
    }
}

class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}

public class MembershipFieldReachChecker {
    public static void main(String[] args) {
        String[][] attempts = {
            {"private", "SAME_CLASS"}, {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"}, {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"}, {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(AccessChecker.summarizeByModifier(attempts));
    }
}