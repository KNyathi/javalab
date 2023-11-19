import java.util.List;

public class AggregateProcessor {
    @DataProcessor
    public String aggregateData(List<String> processedData) {
        //Implement data aggregation 
        
        StringBuilder result = new StringBuilder();
        for (String sentence : processedData) {
        	result.append(sentence).append(" ");
        }
        return result.toString().trim();
    }
}
