package viewSupporter;

import java.util.List;

public class NumberInBounds {
    public static boolean isBoundsNumberTF(String tableNumberString, List<Integer> numberBounds) {
        if (isNumbersTF(tableNumberString) && numberBounds.contains(Integer.parseInt((tableNumberString)))) {
            return true;
        }
        return false;
    }

    private static boolean isNumbersTF(String numbers) {
        boolean numbersTF = true;
        for (int i = 0; i < numbers.length(); i++) {
            numbersTF = numbersTF && isNumberTF(numbers.charAt(i));
        }
        return numbersTF;
    }

    private static boolean isNumberTF(char number) {
        if (number >= '0' && number <= '9') {
            return true;
        }
        return false;
    }
}
