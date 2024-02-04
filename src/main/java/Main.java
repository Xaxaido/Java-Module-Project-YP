import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int personsCount;
        String product;
        double price;
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

        boolean isStop = false;

        while (true) {

            System.out.println("Введите название товара");
            product = scanner.next();

            while (true) {

                System.out.println("Введите стоимость товара");

                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();

                    if (price < 0) {
                        errorMessage();
                    } else {
                        calc.addProduct(product, price);
                        Product newProduct = calc.order.get(calc.order.size() - 1);
                        System.out.println(String.format("Товар '%s' стоимостью %.2f %s успешно добавлен", newProduct.name, newProduct.price,  Formatter.formatRouble(newProduct.price)));
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
                    errorMessage();
                }

            }

            if (isStop) break;

        }

        System.out.println("Добавленные товары:");

        for (int i = 0; i < calc.order.size(); i++) {
            System.out.println(calc.order.get(i).name );
        }

        double eachToPay =  calc.total / calc.personsCount;
        System.out.println(String.format("Сумма к оплате для каждого человека: %.2f %s", eachToPay, Formatter.formatRouble(eachToPay)));
        scanner.close();

    }

    public static void errorMessage() {

        System.out.println("Недопустимый ввод, попробуйте ещё раз");

    }

}