public class Formatter {

    public static String formatRouble(double price) {

        String rouble;
        int roundPrice = (int) Math.floor(price);
        int lastNumber = roundPrice % 10;
        int lastTwoNumbers = 1;

        if (roundPrice >= 10) {
            String intToStr = String.valueOf(roundPrice);
            lastTwoNumbers = Integer.parseInt(intToStr.substring(intToStr.length() - 2));
        }

        if (lastNumber == 1 && lastTwoNumbers != 11) {
                rouble = " рубль";
            } else if (lastNumber >= 2 && lastNumber < 5 && !(lastTwoNumbers > 10 && lastTwoNumbers < 20)) {
                rouble = " рубля";
            } else if (lastNumber == 0 || lastNumber == 1 || lastNumber >= 5 || lastTwoNumbers < 20) {
                rouble = " рублей";
            } else {
                rouble = "";
            }

        return rouble;

    }

}
