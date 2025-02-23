public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // create items
        Item sword = new Item("sword");
        Item shield = new Item("shield");
        Item potion = new Item("armor");

        // add items
        inventory.addItem(sword);
        inventory.addItem(shield);
        inventory.addItem(potion);

        // display items
        inventory.displayItems();

        // check if an item exists
        System.out.println("\nHas sword? " + inventory.hasItem(sword));
        System.out.println("Has bow? " + inventory.hasItem(new Item("bow")));

        // remove an item
        inventory.removeItem(shield);
        inventory.displayItems();

        // try to remove a non-existent item
        inventory.removeItem(shield);

        // check total number of items
        System.out.println("\nTotal items: " + inventory.getItemCount());
    }
}
