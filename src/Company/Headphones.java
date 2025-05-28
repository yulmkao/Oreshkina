package Company;

public class Headphones extends Product {
    private boolean wireless;

    public Headphones(String name, double price, boolean wireless) {
        super(name, price);
        this.wireless = wireless;
    }

    @Override
    public String getInfo() {
        return "Headphones - " + super.getInfo() + ", Wireless: " + (wireless ? "Yes" : "No");
    }
}