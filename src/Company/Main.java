package Company;

public class Main {
    public static void main(String[] args) {
        Warehouse<Smartphone> phoneWarehouse = new Warehouse<>();
        phoneWarehouse.addItem(new Smartphone("iphone 15 pro", 1000, "apple"));
        phoneWarehouse.addItem(new Smartphone("galaxy s22", 800, "samsung"));

        Warehouse<Laptop> laptopWarehouse = new Warehouse<>();
        laptopWarehouse.addItem(new Laptop("macbook pro", 2000, 16));
        laptopWarehouse.addItem(new Laptop("dell xps", 1500, 8));

        Warehouse<Headphones> headphonesWarehouse = new Warehouse<>();
        headphonesWarehouse.addItem(new Headphones("sony WH-1000XM4", 350, true));
        headphonesWarehouse.addItem(new Headphones("bose quietcomfort 35", 300, false));

        printWarehouse(phoneWarehouse);
        printWarehouse(laptopWarehouse);
        printWarehouse(headphonesWarehouse);

        addItem(phoneWarehouse, new Smartphone("google pixel 6", 900, "google"));
        addItem(headphonesWarehouse, new Headphones("airpods pro", 250, true));
        System.out.println("добавим ноутбук lenovo thinkpad: ");
        addLaptopToWarehouse(laptopWarehouse);
        printWarehouse(laptopWarehouse);

        Smartphone foundPhone = phoneWarehouse.getItem(0);
        if (foundPhone != null) {
            System.out.println("найден телефон: " + foundPhone.getInfo());
            phoneWarehouse.removeItem(foundPhone);
        }

        System.out.println("телефоны после удаления:");
        printWarehouse(phoneWarehouse);
    }
    public static void printWarehouse(Warehouse<?> warehouse) {
        warehouse.printAllItems();
        System.out.println();
    }

    public static <T> void addItem(Warehouse<? super T> warehouse, T item) {
        warehouse.addItem(item);
    }

    public static void addLaptopToWarehouse(Warehouse<? super Laptop> warehouse) {
        warehouse.addItem(new Laptop("lenovo thinkpad", 1200, 16));
    }
}