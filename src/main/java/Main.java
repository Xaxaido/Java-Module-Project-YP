import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static String STOP_WORD = "Завершить";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String product;
        double price;
        boolean isStop;
        Calc calc = Calc.getInstance(scanner);

        do {

            System.out.println("Введите название товара");
            product = scanner.next();

            while (true) {

                System.out.println("Введите стоимость товара");

                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();

                    if (price < 0) {
                        Calc.errorMessage();
                    } else {
                        isStop = newProduct(scanner, calc, product, price);
                        break;
                    }
                } else {
                    scanner.next();
                    Calc.errorMessage();
                }

            }

        } while (!isStop);

        Calc.printOrder(calc);
        scanner.close();

    }

    public static boolean newProduct(Scanner scanner, Calc calc, String product, double price) {

        Product newProduct = calc.addProduct(product, price);
        System.out.println(String.format("Товар '%s' стоимостью %.2f %s успешно добавлен",
            newProduct.name, newProduct.price, Formatter.formatValue(newProduct.price, "рубль", "рубля", "рублей")));
        System.out.println("Хотите добавить ещё товар?\nДля продолжения введите любой символ\nДля отображения счёта введите '" + STOP_WORD + "'");

        scanner.nextLine();
        return (scanner.nextLine().equalsIgnoreCase(STOP_WORD));

    }

}