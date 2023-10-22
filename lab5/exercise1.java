import java.util.regex.*;
import java.util.regex.PatternSyntaxException;

public class exercise1 {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99";

        try {
            Pattern pattern = Pattern.compile("\\d+\\.\\d+");
            Matcher matcher = pattern.matcher(text);
            boolean found = false;  // Flag to track if numbers were found

            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;  // Set the flag to true if at least one number is found
            }

            if (!found) {
                System.out.println("No numbers found in the text.");
            }
        } catch (PatternSyntaxException e) {
            System.err.println("There was a problem with the regular expression pattern: " + e.getMessage());
        }
    }
}
