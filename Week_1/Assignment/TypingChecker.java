class TypingTest {
    void checkTyping(String original, String typed) {
        int score = 0;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                score++;
            }
        }
		
        System.out.println("Correct characters: " + score);

        if (original.equals(typed)) {
            System.out.println("Result: Perfect match!");
        } else {
            System.out.println("Result: Contains mistakes.");
        }
    }
}

class TypingChecker {
    public static void main(String[] args) {
        String original = "hello";
        String typed = "helxo";

        TypingTest checker = new TypingTest();
        checker.checkTyping(original, typed);
    }
}