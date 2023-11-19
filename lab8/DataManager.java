import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class DataManager {
    private List<Object> dataProcessors;
    private List<String> data;
    private List<String> processedData;

    public DataManager() {
        this.dataProcessors = new ArrayList<>();
        this.processedData = new ArrayList<>();
    }

    public void registerDataProcessor(Object processor) {
        dataProcessors.add(processor);
    }

    public void loadData(String sourcePath) {
        try {
            this.data = Files.readAllLines(Paths.get(sourcePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


public void processData() {
    processedData.clear();
    List<String> intermediateData = new ArrayList<>(data);

    CompletableFuture<Void> filterFuture = CompletableFuture.runAsync(() -> {
        try {
            System.out.println("Filtering started");
            List<String> filteredData = applyDataProcessor(new FilterProcessor(), intermediateData);
            System.out.println("Filtering completed");
            intermediateData.clear();
            intermediateData.addAll(filteredData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });

    CompletableFuture<Void> transformFuture = filterFuture.thenRunAsync(() -> {
        try {
            System.out.println("Transforming started");
            List<String> transformedData = applyDataProcessor(new TransformProcessor(), intermediateData);
            System.out.println("Transforming completed");
            intermediateData.clear();
            intermediateData.addAll(transformedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });

    CompletableFuture<Void> aggregateFuture = transformFuture.thenRunAsync(() -> {
        try {
            System.out.println("Aggregating started");
            String aggregatedData = applyDataProcessor(new AggregateProcessor(), intermediateData).get(0);
            System.out.println("Aggregating completed");
            synchronized (processedData) {
                processedData.add(aggregatedData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    });

    CompletableFuture<Void> allOf = CompletableFuture.allOf(filterFuture, transformFuture, aggregateFuture);
    try {
        allOf.get(); // Wait for all tasks to complete
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }

    saveData("destination.txt");
}


private List<String> applyDataProcessor(Object processor, List<String> inputData) {
    if (processor instanceof FilterProcessor) {
        return ((FilterProcessor) processor).filterData(inputData);
    } else if (processor instanceof TransformProcessor) {
        return ((TransformProcessor) processor).transformData(inputData);
    } else if (processor instanceof AggregateProcessor) {
        return List.of(((AggregateProcessor) processor).aggregateData(inputData));
    } else {
        System.out.println("Unsupported processor type: " + processor.getClass().getSimpleName());
        return new ArrayList<>();  // or handle unsupported type accordingly
    }
}

public void saveData(String destination) {
    try {
        if (!processedData.isEmpty()) {
            String processedDataString = String.join("\n", processedData);
            Files.write(Paths.get(destination), processedDataString.getBytes());
        } else {
            System.out.println("Processed data is empty.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
