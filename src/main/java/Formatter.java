public final class Formatter {

    public static String formatValue(final double value, final String[] valueNameToFormat) {

        int roundedValue = (int) Math.floor(value);
        int preLastNumber = roundedValue % 100 / 10;
        int lastNumber = roundedValue % 10;

        if (preLastNumber == 1) {
            return " " + valueNameToFormat[2];
        }

        return switch (lastNumber) {
            case 1 -> " " + valueNameToFormat[0];
            case 2, 3, 4 -> " " + valueNameToFormat[1];
            default -> " " + valueNameToFormat[2];
        };

    }

}