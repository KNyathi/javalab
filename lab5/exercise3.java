
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class exercise3 {
    public static void main(String[] args) {
        try {
            // The input text with links
            String inputText = "Hello, here is my website: http://www.examplekhaya.ru and my email: contact@example.com. Also, visit https://www.example.org or https://www.example.com/page?param=value.";

            // Regular expression to find links in the text (URL with valid domain name)
            String regex = "\\bhttps?://([A-Za-z0-9.-]+\\.[A-Za-z]{2,}|localhost|\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})(:[0-9]+)?(/\\S*)?";

            // Create a Pattern object
            Pattern pattern = Pattern.compile(regex);

            // Create a Matcher object to find links
            Matcher matcher = pattern.matcher(inputText);

            // Find and store valid URLs in a list
            List<String> validUrls = new ArrayList<>();
            while (matcher.find()) {
                validUrls.add(matcher.group());
            }

            // Replace the found links with hyperlinks
            String resultText = inputText;
            for (String url : validUrls) {
                resultText = resultText.replace(url, "<a href=\"" + url + "\">" + url + "</a>");
            }

            // Print the modified text
            System.out.println(resultText);
        } catch (PatternSyntaxException e) {
            System.err.println("Pattern syntax exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
