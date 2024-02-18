import java.util.ArrayList;

public final class Calc {

    private final int personsCount;
    private double total;
    private final ArrayList<Product> order;
    final static String[] valueToFormat = {"рубль", "рубля", "рублей"};
    private int maxLength = 0;

    public static Calc getInstance(final MyScanner scanner) {

        Calc calc = null;

        while (calc == null) {

            System.out.println("На скольких человек необходимо разделить счёт?");

            int personsCount = scanner.nextInt();
            if (personsCount >= 2) {
                calc = new Calc(personsCount, new ArrayList<Product>());
            } else {
                MyScanner.errorMessage();
            }

        }

        return calc;

    }

    public void addProduct(final String name, final double price) {

        Product newProduct = new Product(name, price);
        order.add(newProduct);
        total += price;
        maxLength = Math.max(maxLength, name.length());

    }

    public void printOrder() {

        System.out.println("Добавленные товары:");

        for (Product product : order) {
            String name = product.getName();
            double price = product.getPrice();
            System.out.println(String.format(name + ".".repeat(maxLength - name.length() + 5) + "%.2f" +
                                            Formatter.formatValue(price, valueToFormat), price));
        }

        double eachToPay =  total / personsCount;
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
