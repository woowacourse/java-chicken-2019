package viewSupporter;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    public static List<Integer> createNumberList(int number) {
        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            numberList.add(i);
        }
        return numberList;
    }
}
