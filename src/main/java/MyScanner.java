import java.io.InputStream;
import java.util.Scanner;

public class MyScanner {

    private final Scanner scanner;

    public String next() {
        return scanner.next();
    }

    public int nextInt() {
        return (int) readValue(scanner.next());
    }

    public double nextDouble() {
        return readValue(scanner.next());
    }

    private static double readValue(String value) {

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

    public MyScanner(InputStream in) {
        this.scanner = new Scanner(in);
    }

}
