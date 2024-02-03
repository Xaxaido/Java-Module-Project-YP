public class Formatter {

    public static String formatRouble(double price) {

        String rouble;
        int roundPrice = (int) Math.floor(price);
        int lastNumber = roundPrice % 10;

        if (roundPrice == 1 || lastNumber == 1) {
                rouble = " рублю";
            } else if (roundPrice < 5 || (roundPrice > 21 && lastNumber >= 2 && lastNumber < 5)) {
                rouble = " рубля";
            } else if (roundPrice <= 20 || roundPrice >= 25 && (lastNumber == 0 || lastNumber >= 5)) {
                rouble = " рублей";
            } else {
                rouble = "";
            }

        return rouble;

    }

}
