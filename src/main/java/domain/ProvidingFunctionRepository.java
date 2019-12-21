package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProvidingFunctionRepository {
    private static final int ORDER_REGISTRATION_FUNCTION = 1;
    private static final int PAYMENT_FUNCTION = 2;
    private static final int EXIT = 3;

    private static final List<ProvidingFunction> providingFunctions
            = new ArrayList<ProvidingFunction>();

    static {
        providingFunctions.add(new ProvidingFunction(1, "주문등록"));
        providingFunctions.add(new ProvidingFunction(2, "결제하기"));
        providingFunctions.add(new ProvidingFunction(3, "프로그램 종료"));
    }

    public static List<ProvidingFunction> providingFunctions() {
        return Collections.unmodifiableList(providingFunctions);
    }

    public static boolean isOrderRegistration(int requestNumber) {

        if (requestNumber == ORDER_REGISTRATION_FUNCTION) {
            return true;
        }

        return false;
    }

    public static boolean isPayment(int requestNumber) {

        if (requestNumber == PAYMENT_FUNCTION) {
            return true;
        }

        return false;
    }

    public static boolean isExit(int requestNumber) {

        if (requestNumber == EXIT) {
            return true;
        }

        return false;
    }
}
