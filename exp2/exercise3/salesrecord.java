import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SalesAnalysis {
    public static void main(String[] args) {
        List<SalesRecord> sales = new ArrayList<>();
        sales.add(new SalesRecord("1", "Alice", "North", 300.0, "2023-01-01", "Electronics", 10));
        sales.add(new SalesRecord("2", "Bob", "South", 150.0, "2023-01-02", "Furniture", 5));
        sales.add(new SalesRecord("3", "Charlie", "North", 500.0, "2023-01-03", "Electronics", 20));

        // Filter and sort records
        List<SalesRecord> filteredSortedSales = sales.stream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());

        // Print sorted records
        filteredSortedSales.forEach(System.out::println);

        // Calculate average sales for North region
        double averageSales = sales.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .mapToDouble(SalesRecord::getAmount)
                .average()
                .orElse(0.0);
        System.out.println("Average Sales: " + averageSales);

        // Find top sales record
        SalesRecord topSalesRecord = sales.stream()
                .max(Comparator.comparing(SalesRecord::getAmount))
                .orElse(null);
        System.out.println("Top Sales Record: " + topSalesRecord);

        // Parallel stream operations
        long start = System.nanoTime();
        sales.parallelStream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        long end = System.nanoTime();
        System.out.println("Parallel Stream Time: " + (end - start) + " ns");
    }
}
