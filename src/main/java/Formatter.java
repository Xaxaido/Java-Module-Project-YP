public class Formatter {

    public static String formatValue(double value, String firstVariation, String secondVariation, String thirdVariation) {

        int roundedValue = (int) Math.floor(value);
        int preLastNumber = roundedValue % 100 / 10;
        int lastNumber = roundedValue % 10;

        if (preLastNumber == 1) {
            return " " + thirdVariation;
        }

        return switch (lastNumber) {
            case 1 -> " " + firstVariation;
            case 2, 3, 4 -> " " + secondVariation;
            default -> " " + thirdVariation;
        };

    }

}