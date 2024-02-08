import java.util.ArrayList;
import java.util.Scanner;

public class Calc {

    int personsCount;
    double total;
    ArrayList<Product> order;
    final static String[] valueToFormat = {"рубль", "рубля", "рублей"};
    private static int maxLength = 0;

    public static Calc getInstance(Scanner scanner) {

        int personsCount;
        Calc calc;

        while (true) {

            System.out.println("На скольких человек необходимо разделить счёт?");

            if (scanner.hasNextInt()) {
                personsCount = scanner.nextInt();

                if (personsCount <= 1) {
                    errorMessage();
                } else {
                    calc = new Calc(personsCount, new ArrayList<Product>());
                    break;
                }

            } else {
                scanner.next();
                errorMessage();
            }

        }

        return calc;

    }

    public Product addProduct(String name, double price) {

        Product newProduct = new Product(name, price);
        this.order.add(newProduct);
        this.total = this.total + price;

        maxLength = Math.max(maxLength, name.length());

        return newProduct;

    }

    public static void printOrder(Calc calc) {

        System.out.println("Добавленные товары:");

        for (int i = 0; i < calc.order.size(); i++) {
            Product product = calc.order.get(i);
            System.out.println(String.format(product.name + ".".repeat(maxLength - product.name.length() + 5) + "%.2f" +
                                            Formatter.formatValue(product.price, valueToFormat), product.price));
        }

        double eachToPay =  calc.total / calc.personsCount;
        String total = String.format("Сумма к оплате для каждого человека: %.2f %s",
                                    eachToPay, Formatter.formatValue(eachToPay, valueToFormat));
        System.out.println("_".repeat(total.length()));
        System.out.println(total);

    }

    public static double fixDouble(String price) {

        double newPrice;

        try {
            newPrice = Double.parseDouble(price);
        } catch(NumberFormatException e) {
            newPrice = -1;
        }

        return newPrice;

    }

    public static void errorMessage() {

        System.out.println("Недопустимый ввод, попробуйте ещё раз");

    }

    Calc(int personsCount, ArrayList<Product> order) {

        this.personsCount = personsCount;
        this.order = order;

    }

}
