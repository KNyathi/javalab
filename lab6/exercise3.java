import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.Map.Entry;

public class exercise3 {
    private ConcurrentHashMap<String, AtomicInteger> salesData;

    public exercise3() {
        salesData = new ConcurrentHashMap<>();
    }

    public void recordSale(String product, int quantity) {
        // Update the sales quantity for the given product
        salesData.compute(product, (key, value) -> {
            if (value == null) {
                return new AtomicInteger(quantity);
            } else {
                value.addAndGet(quantity);
                return value;
            }
        });
    }

    public void printSalesReport() {
        System.out.println("Sales Report:");
        for (Entry<String, AtomicInteger> entry : salesData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().get());
        }
    }

    public int getTotalSales() {
        int totalSales = 0;
        for (AtomicInteger quantity : salesData.values()) {
            totalSales += quantity.get();
        }
        return totalSales;
    }

    public String getMostPopularProduct() {
        String mostPopularProduct = null;
        int maxQuantity = 0;
        for (Entry<String, AtomicInteger> entry : salesData.entrySet()) {
            int quantity = entry.getValue().get();
            if (quantity > maxQuantity) {
                mostPopularProduct = entry.getKey();
                maxQuantity = quantity;
            }
        }
        return mostPopularProduct;
    }

    public static void main(String[] args) {
        exercise3 salesTracker = new exercise3();

        salesTracker.recordSale("ProductA", 5);
        salesTracker.recordSale("ProductB", 10);
        salesTracker.recordSale("ProductA", 3);

        salesTracker.printSalesReport();
        System.out.println("Total Sales: " + salesTracker.getTotalSales());
        System.out.println("Most Popular Product: " + salesTracker.getMostPopularProduct());
    }
}
