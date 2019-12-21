package domain;

import java.util.ArrayList;
import java.util.List;

public class ProvidingFunctionRepository {
    private static final List<ProvidingFunction> providingFunctions
            = new ArrayList<ProvidingFunction>();

    static {
        providingFunctions.add(new ProvidingFunction(1, "주문등록"));
        providingFunctions.add(new ProvidingFunction(2, "결제하기"));
        providingFunctions.add(new ProvidingFunction(3, "프로그램 종료"));
    }
}
