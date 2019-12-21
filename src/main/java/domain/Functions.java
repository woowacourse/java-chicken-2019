package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Functions {
    Order order = new Order();
    private static final List<String> functions = new ArrayList<>();



    public static List<String> functions() {
        return Collections.unmodifiableList(functions);
    }

}
