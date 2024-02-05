public class Formatter {

    public static String formatValue(double value, String firstVariation, String secondVariation, String thirdVariation) {

        int roundPrice = (int) Math.floor(value);

        int preLastDigit = roundPrice % 100 / 10;
        if (preLastDigit == 1) {
            return " " + thirdVariation;
        }

        int lastDigit = roundPrice % 10;
        switch (lastDigit) {
            case 1:
                return " " + firstVariation;
            case 2:
            case 3:
            case 4:
                return " " + secondVariation;
            default:
                return " " + thirdVariation;
        }

    }

}