import java.io.InputStream;
import java.util.Scanner;

public final class MyScanner {

    private final Scanner scanner;

    public String next() { return scanner.next(); }

    public int nextInt() { return (int) nextDouble(); }

    public double nextDouble() {
        return readValue(scanner.next());
    }

    private double readValue(final String value) {

        double newValue;

        try {
            newValue = Double.parseDouble(value);
        } catch(NumberFormatException e) {
            newValue = -1;
        }

        return newValue;

    }

    public void close() {
        scanner.close();
    }

    public static void errorMessage() { System.out.println("Недопустимый ввод, попробуйте ещё раз"); }

    public MyScanner(InputStream in) {
        this.scanner = new Scanner(in);
    }

}
