import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public List<String> filterData(List<String> sentences) {
        // Implement data filtering
        
        List<String> filteredData = sentences.stream()
                .filter(sentence -> sentence.contains("fruit"))
                .collect(Collectors.toList());
                
        System.out.println("filtered data: " + filteredData);
        
        return filteredData;
               
    }
}
