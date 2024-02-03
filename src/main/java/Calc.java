import java.util.ArrayList;

public class Calc {

    int personsCount;
    double total;
    ArrayList<Product> order;

    public void addProduct(String name, double price) {

        this.order.add(new Product(name, price));
        this.total = this.total + price;

    }

    Calc(int personsCount, ArrayList<Product> order) {

        this.personsCount = personsCount;
        this.order = order;
    }

}
