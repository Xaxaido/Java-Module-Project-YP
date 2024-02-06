import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String product;
        double price;
        boolean isStop = false;
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
                        calc.addProduct(product, price);
                        Product newProduct = calc.order.get(calc.order.size() - 1);
                        System.out.println(String.format("Товар '%s' стоимостью %.2f %s успешно добавлен", newProduct.name, newProduct.price, Formatter.formatValue(newProduct.price, "рубль", "рубля", "рублей")));
                        System.out.println("Хотите добавить ещё товар?\nДля продолжения введите любой символ.\nДля завершения добавления товаров введите 'Завершить'");

                        scanner.nextLine();
                        String command = scanner.nextLine();
                        if (command.equalsIgnoreCase("Завершить")) {
                            isStop = true;
                        }
                        break;
                    }
                } else {
                    scanner.next();
                    Calc.errorMessage();
                }

            }

        } while (!isStop);

        printProducts(calc);
        scanner.close();

    }

    public static void printProducts(Calc calc) {

        System.out.println("Добавленные товары:");

        for (int i = 0; i < calc.order.size(); i++) {
            System.out.println(calc.order.get(i).name );
        }

        double eachToPay =  calc.total / calc.personsCount;
        System.out.println(String.format("Сумма к оплате для каждого человека: %.2f %s", eachToPay, Formatter.formatValue(eachToPay, "рубль", "рубля", "рублей")));

    }

}