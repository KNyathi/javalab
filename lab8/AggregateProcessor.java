import java.util.List;

public class AggregateProcessor {
    @DataProcessor
    public int aggregateData(List<String> sentences) {
        // Implement data aggregation (e.g., count the number of sentences)
        return sentences.size();
    }
}
