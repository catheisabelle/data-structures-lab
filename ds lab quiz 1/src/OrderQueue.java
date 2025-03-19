import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<String> regularOrders;
    private Queue<String> priorityOrders;

    public OrderQueue() {
        regularOrders = new LinkedList<>();
        priorityOrders = new LinkedList<>();
    }

    // Adds a new order to the regular queue.
    public void addRegularOrder(String order) {
        regularOrders.add(order);
    }

    // Adds a new order to the priority queue.
    public void addPriorityOrder(String order) {
        priorityOrders.add(order);
    }

    // Processes the next available order, prioritizing priority orders first. (Processes orders)
    public String processNextOrder() {
        if (!priorityOrders.isEmpty()) {
            return priorityOrders.poll();
        } else if (!regularOrders.isEmpty()) {
            return regularOrders.poll();
        } else {
            throw new IllegalStateException("no orders available");
        }
    }

    // Removes an order from either queue if found. Returns a boolean to show success/failure in cancelling order.
    public boolean cancelOrder(String order) {
        if (priorityOrders.remove(order) || regularOrders.remove(order)) {
            return true;
        }
        return false;
    }

    // Displays all orders, showing priority orders first.
    public void displayOrders() {
        System.out.println("Priority orders: " + priorityOrders);
        System.out.println("Regular orders: " + regularOrders);
    }

    // Uses recursion to check if an order exists in either queue. Returns a boolean depending on whether the order is found or not.
    public boolean orderExists(String order) {
        return orderExistsRecursive(priorityOrders, order) || orderExistsRecursive(regularOrders, order);
    }

    private boolean orderExistsRecursive(Queue<String> queue, String order) {
        if (queue.isEmpty()) {
            return false;
        }
        String first = queue.poll();
        boolean exists = first.equals(order) || orderExistsRecursive(queue, order);
        queue.add(first);
        return exists;
    }

    public static void main(String[] args) {
        OrderQueue queue = new OrderQueue();

        queue.addRegularOrder("burger");
        queue.addRegularOrder("pizza");
        queue.addRegularOrder("noodles");
        queue.addPriorityOrder("sushi");
        queue.addPriorityOrder("ramen");
        queue.addPriorityOrder("fried rice");

        System.out.println("processing: " + queue.processNextOrder());
        queue.displayOrders();

        System.out.println("Order exists (pizza): " + queue.orderExists("pizza"));
        System.out.println("Cancelling order (pizza): " + queue.cancelOrder("pizza"));

        queue.displayOrders();
    }
}
