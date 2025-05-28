package Company;

public class Smartphone extends Product {
    private String brand;

    public Smartphone(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public String getInfo() {
        return "Smartphone - " + brand + " " + super.getInfo();
    }
}