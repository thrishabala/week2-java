import java.util.ArrayList;
import java.util.List;

public class OrderProcessing {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Alice", 150.0, "NEW"));
        orders.add(new Order("2", "Bob", 250.0, "NEW"));
        orders.add(new Order("3", "Charlie", 50.0, "NEW"));

        // Filter orders with amount > 100
        OrderFilter amountFilter = order -> order.getOrderAmount() > 100;
        processOrders(orders, amountFilter, order -> order.setStatus("PROCESSED"));

        // Print processed orders
        orders.forEach(System.out::println);
    }

    public static void processOrders(List<Order> orders, OrderFilter filter, OrderProcessor processor) {
        for (Order order : orders) {
            if (filter.filter(order)) {
                processor.process(order);
            }
        }
    }
}
