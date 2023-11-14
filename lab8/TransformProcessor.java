import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor
    public List<String> transformData(List<String> sentences) {
        // Implement data transformation (e.g., convert sentences to lowercase)
        return sentences.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
