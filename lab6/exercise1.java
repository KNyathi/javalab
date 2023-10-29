import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class exercise1 {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = "source.txt";
        // Create a File object
        File file = new File(filePath);
        // Create a Scanner object to read the file
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Create a Map to store words and their counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read the file word by word and add them to the Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            // Remove punctuation and special characters
            word = word.replaceAll("[^a-zA-Z]", "");

            if (!word.isEmpty()) {
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
        }

        // Close the Scanner
        scanner.close();

        // Create a list of Map entries
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        // Sort the list in descending order of word counts
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Display the top 10 words
        int topN = 10;
        for (int i = 0; i < topN && i < list.size(); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
