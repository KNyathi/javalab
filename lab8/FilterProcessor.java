import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public List<String> filterData(List<String> sentences) {
        // Implement data filtering (e.g., keep only sentences containing "fruit")
        return sentences.stream()
                .filter(sentence -> sentence.contains("fruit"))
                .collect(Collectors.toList());
    }
}
