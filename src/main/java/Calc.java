import java.util.ArrayList;
import java.util.Scanner;

public class Calc {

    int personsCount;
    double total;
    ArrayList<Product> order;

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

    public void addProduct(String name, double price) {

        this.order.add(new Product(name, price));
        this.total = this.total + price;

    }

    public static void printOrder(Calc calc) {

        System.out.println("Добавленные товары:");

        for (int i = 0; i < calc.order.size(); i++) {
            System.out.println(calc.order.get(i).name );
        }

        double eachToPay =  calc.total / calc.personsCount;
        System.out.println(String.format("Сумма к оплате для каждого человека: %.2f %s", eachToPay, Formatter.formatValue(eachToPay, "рубль", "рубля", "рублей")));

    }

    public static void errorMessage() {

        System.out.println("Недопустимый ввод, попробуйте ещё раз");

    }

    Calc(int personsCount, ArrayList<Product> order) {

        this.personsCount = personsCount;
        this.order = order;
    }

}
