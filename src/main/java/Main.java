import java.util.Scanner;

public class Main {

    final static String STOP_WORD = "Завершить";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String productName;
        double price;
        boolean isStop;
        Calc calc = Calc.getInstance(scanner);

        do {

            System.out.println("Введите название товара");
            productName = scanner.next();

            while (true) {

                System.out.println("Введите стоимость товара");

                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();

                    if (price < 0) {
                        Calc.errorMessage();
                    } else {
                        isStop = newProductOrStop(scanner, calc, productName, price);
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

    public static boolean newProductOrStop(Scanner scanner, Calc calc, String productName, double price) {

        calc.addProduct(productName, price);
        System.out.println(String.format("Товар '%s' стоимостью %.2f %s успешно добавлен",
                                        productName, price, Formatter.formatValue(price, "рубль", "рубля", "рублей")));
        System.out.println("Хотите добавить ещё товар?\nДля продолжения введите любой символ\nДля отображения счёта введите '" + STOP_WORD + "'");
        scanner.nextLine();

        return scanner.nextLine().equalsIgnoreCase(STOP_WORD);

    }

}