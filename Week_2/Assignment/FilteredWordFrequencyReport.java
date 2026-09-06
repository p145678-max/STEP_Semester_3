public class FilteredWordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        feedback = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = feedback.split("\\s+");

        String[] uniqueWords = new String[words.length];
        int[] count = new int[words.length];
        int uniqueCount = 0;

        for (int i = 0; i < words.length; i++) {

            boolean stopWord = false;

            for (int j = 0; j < stopWords.length; j++) {
                if (words[i].equals(stopWords[j])) {
                    stopWord = true;
                    break;
                }
            }

            if (!stopWord) {

                int position = -1;

                for (int j = 0; j < uniqueCount; j++) {
                    if (uniqueWords[j].equals(words[i])) {
                        position = j;
                        break;
                    }
                }

                if (position == -1) {
                    uniqueWords[uniqueCount] = words[i];
                    count[uniqueCount] = 1;
                    uniqueCount++;
                } else {
                    count[position]++;
                }
            }
        }

        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {

                if (count[j] > count[i]) {

                    int tempCount = count[i];
                    count[i] = count[j];
                    count[j] = tempCount;

                    String tempWord = uniqueWords[i];
                    uniqueWords[i] = uniqueWords[j];
                    uniqueWords[j] = tempWord;
                }
            }
        }

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(uniqueWords[i] + ": " + count[i]);
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency(
                "The mentor was great, the session was great and clear.");
    }
}