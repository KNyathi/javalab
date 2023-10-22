import java.util.regex.*;

public class exercise5 {
    public static void main(String[] args) {
        try {
            // Input sentence
            String sentence = "This is a sample sentence with words that start with a specific letter.";

            // Letter to search for
            char searchLetter = '9';

            // Check if the searchLetter is a letter
            if (!Character.isLetter(searchLetter)) {
                System.err.println("Invalid search letter. Please enter a valid letter.");
                return;
            }

            // Regular expression to find words starting with the specified letter
            String regex = "\\b" + searchLetter + "\\w*";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sentence);

            System.out.println("Words starting with the letter '" + searchLetter + "':");

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Invalid regular expression pattern: " + e.getMessage());
        }
    }
}
