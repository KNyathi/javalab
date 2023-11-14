import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class DataManager {
    private List<Object> dataProcessors;
    private List<String> data; // Assuming data is a list of strings



    public DataManager() {
        this.dataProcessors = new ArrayList<>();
   
    }



    public void registerDataProcessor(Object processor) {
        dataProcessors.add(processor);
    }



    public void loadData(String sourcePath) {
   	try {
            // Read data from the source file into the 'data' list
            this.data = Files.readAllLines(Paths.get(sourcePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (Object processor : dataProcessors) {
            executorService.submit(() -> {
                // Apply methods annotated with @DataProcessor using the Stream API
                applyDataProcessor(processor);
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    

    private void applyDataProcessor(Object processor) {
        // Apply the DataProcessor methods using Stream API
    Stream.of(processor.getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(DataProcessor.class))
            .forEach(method -> {
                try {
                    // Ensure that the DataProcessor method doesn't require arguments
                    if (method.getParameterCount() == 0) {
                        method.invoke(processor);
                    } else {
                        // Handle methods with parameters based on your specific logic
                        // For simplicity, skipping methods with parameters for now
                        System.out.println("Skipping method with parameters: " + method.getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
    }


    public void saveData(String destination) {
        try {
            // Join the processed sentences into a single string with line breaks
            String processedData = String.join("\n", data);

            // Write the processed data to the destination file (destination.txt)
            Files.write(Paths.get(destination), processedData.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
