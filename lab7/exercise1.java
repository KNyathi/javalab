import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class exercise1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 4; // Number of threads

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        List<Future<Integer>> results = new ArrayList<>();

        // Divide the array into chunks and submit each chunk for execution in a separate thread
        int chunkSize = array.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? array.length : startIndex + chunkSize;
            int[] chunk = Arrays.copyOfRange(array, startIndex, endIndex);

            Callable<Integer> task = () -> {
                int sum = 0;
                for (int num : chunk) {
                    sum += num;
                }
                return sum;
            };

            Future<Integer> result = executor.submit(task);
            results.add(result);
        }

        // Wait for all threads to finish execution
        int totalSum = 0;
        for (Future<Integer> result : results) {
            try {
                totalSum += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the thread pool
        executor.shutdown();

        System.out.println("Total sum: " + totalSum);
    }
}
