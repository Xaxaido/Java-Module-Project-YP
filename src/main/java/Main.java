public class Main {

    private final static String STOP_WORD = "Завершить";

    public static void main(String[] args) {

        MyScanner scanner = new MyScanner(System.in);
        String productName;
        double price;
        boolean isStop;
        Calc calc = Calc.getInstance(scanner);

        do {

            System.out.println("Введите название товара");
            productName = scanner.next();

            while (true) {

                System.out.println("Введите стоимость товара");
                price = scanner.nextDouble();

                if (price < 0) {
                    MyScanner.errorMessage();
                } else {
                    isStop = newProductOrStop(scanner, calc, productName, price);
                    break;
                }

            }

        } while (!isStop);

        calc.printOrder();
        scanner.close();

    }

    private static boolean newProductOrStop(final MyScanner scanner, final Calc calc, final String productName, final double price) {

        calc.addProduct(productName, price);
        System.out.println(String.format("Товар '%s' стоимостью %.2f %s успешно добавлен",
                                        productName, price, Formatter.formatValue(price, Calc.valueToFormat)));
        System.out.println("Хотите добавить ещё товар?\nДля продолжения введите любой символ\nДля отображения счёта введите '" + STOP_WORD + "'");

        return scanner.next().equalsIgnoreCase(STOP_WORD);

    }

}