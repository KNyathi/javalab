import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class exercise3 {
    public static void main(String[] args) {
        int[] items = {30, 60, 40, 20, 10, 35, 50, 55, 15}; // Weight of each item

        int maxCapacity = 150; // Maximum carrying capacity of workers
        int numWorkers = 3; // Number of workers

        CountDownLatch startSignal = new CountDownLatch(1); // Signal to start the transfer
        CountDownLatch doneSignal = new CountDownLatch(numWorkers); // Signal to finish the transfer

        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);

        for (int i = 0; i < numWorkers; i++) {
            final int workerId = i;
            executor.execute(() -> {
                try {
                    startSignal.await(); // Worker waits for the start of the transfer

                    int currentWeight = 0;
                    for (int item : items) {
                        if (currentWeight + item <= maxCapacity) {
                            currentWeight += item;
                            System.out.println("Worker " + workerId + " is carrying item " + item + " kg.");
                        } else {
                            System.out.println("Worker " + workerId + " has reached max capacity. Going to the other warehouse.");
                            currentWeight = item;
                        }
                    }

                    doneSignal.countDown(); // Worker has finished the transfer
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("Starting the transfer...");
        startSignal.countDown(); // Allow the transfer to start

        try {
            doneSignal.await(); // Wait for all workers to finish the transfer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Transfer is complete. All workers have finished.");
        executor.shutdown();
    }
}
