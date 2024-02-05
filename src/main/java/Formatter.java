public class Formatter {

    public static String formatValue(double value, String firstVariation, String secondVariation, String thirdVariation) {

        int roundPrice = (int) Math.floor(value);

        int preLastNumber = roundPrice % 100 / 10;
        if (preLastNumber == 1) {
            return " " + thirdVariation;
        }

        int lastNumber = roundPrice % 10;
        return switch (lastNumber) {
            case 1 -> " " + firstVariation;
            case 2, 3, 4 -> " " + secondVariation;
            default -> " " + thirdVariation;
        };

    }

}