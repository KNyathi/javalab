import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor
    public List<String> transformData(List<String> sentences) {
        // Implement data transformation 
        
        List<String> transformedData = sentences.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
                
        System.out.println("transformed data: " + transformedData);       
        return transformedData;
    }
}
