class InventoryChecker {
    void analyzeInventory(int[] sectionA, int[] sectionB) {        
        int totalA = 0;
        int totalB = 0;
        
		int maxA = sectionA[0];
        int maxAIndex = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxA) {
                maxA = sectionA[i];
                maxAIndex = i;
            }
        }
		
        int maxB = sectionB[0];
        int maxBIndex = 0;
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxB) {
                maxB = sectionB[i];
                maxBIndex = i;
            }
        }

        String status = "Not Balanced";
        if (totalA == totalB) {
            status = "Balanced";
        }

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB);
        System.out.println("Status: " + status);

        if (maxA >= maxB) {
            System.out.println("Highest: " + maxA + " (Section A, Item " + (maxAIndex + 1) + ")");
        } else {
            System.out.println("Highest: " + maxB + " (Section B, Item " + (maxBIndex + 1) + ")");
        }
    }
}

class InventoryCheck{
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        InventoryChecker checker = new InventoryChecker();
        checker.analyzeInventory(sectionA, sectionB);
    }
}