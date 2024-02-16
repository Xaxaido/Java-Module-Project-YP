public final class Product {

    private final String name;
    private final double price;

    public String getName(Product product) { return product.name; }

    public double getPrice(Product product) { return product.price; }

    Product(String name, double price) {

        this.name = name;
        this.price = price;

    }

}
