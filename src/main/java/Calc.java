import java.util.ArrayList;

public final class Calc {

    private final int personsCount;
    private double total;
    private final ArrayList<Product> order;
    final static String[] valueToFormat = {"рубль", "рубля", "рублей"};
    private static int maxLength = 0;

    public static Calc getInstance(final MyScanner scanner) {

        int personsCount;
        Calc calc;

        while (true) {

            System.out.println("На скольких человек необходимо разделить счёт?");

            personsCount = scanner.nextInt();
            if (personsCount >= 2) {
                calc = new Calc(personsCount, new ArrayList<Product>());
                break;
            } else {
                MyScanner.errorMessage();
            }

        }

        return calc;

    }

    public void addProduct(final String name, final double price) {

        Product newProduct = new Product(name, price);
        this.order.add(newProduct);
        this.total += price;
        maxLength = Math.max(maxLength, name.length());

    }

    public void printOrder() {

        System.out.println("Добавленные товары:");

        for (int i = 0; i < this.order.size(); i++) {
            Product product = this.order.get(i);
            String name = product.getName();
            double price = product.getPrice();
            System.out.println(String.format(name + ".".repeat(maxLength - name.length() + 5) + "%.2f" +
                                            Formatter.formatValue(price, valueToFormat), price));
        }

        double eachToPay =  this.total / this.personsCount;
        String total = String.format("Сумма к оплате для каждого человека: %.2f %s",
                                    eachToPay, Formatter.formatValue(eachToPay, valueToFormat));
        System.out.println("_".repeat(total.length()));
        System.out.println(total);

    }

    Calc(int personsCount, ArrayList<Product> order) {

        this.personsCount = personsCount;
        this.order = order;

    }

}
