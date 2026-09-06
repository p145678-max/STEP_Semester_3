class TrafficAnalyzer {
    void findLongestStreak(String log) {
        int maxStreak = 1;
        int currentStreak = 1;
        char bestColor = log.charAt(0);
        for (int i = 1; i < log.length(); i++) {
            char current = log.charAt(i);
            char previous = log.charAt(i - 1);
			
            if (current == previous) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }
			
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                bestColor = current;
            }
        }
		
        System.out.println("Longest streak: '" + bestColor + "' repeated " + maxStreak + " times.");
    }
}

class TrafficSignal {
    public static void main(String[] args) {
        String signalLog = "RRGGGYRR";

        TrafficAnalyzer analyzer = new TrafficAnalyzer();
        analyzer.findLongestStreak(signalLog);
    }
}