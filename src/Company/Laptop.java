package Company;

public class Laptop extends Product {
    private int ram;

    public Laptop(String name, double price, int ram) {
        super(name, price);
        this.ram = ram;
    }

    @Override
    public String getInfo() {
        return "Laptop - " + super.getInfo() + ", RAM: " + ram + "GB";
    }
}