import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    // Constructor
    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Method to add an item to the inventory
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " added to inventory.");
    }

    // Method to remove an item from the inventory
    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item.getName() + " removed from inventory.");
        } else {
            System.out.println("Error: " + item.getName() + " not found in inventory.");
        }
    }

    // Method to check if an item exists in the inventory
    public boolean hasItem(Item item) {
        return items.contains(item);
    }

    // Method to display all items in the inventory
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory contains:");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
    }

    // Method to get the total number of items
    public int getItemCount() {
        return items.size();
    }
}

