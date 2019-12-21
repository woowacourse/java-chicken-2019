package domain;

import java.util.ArrayList;
import java.util.List;

public class MainFeatures {
    private static final String ORDER_REGISTRATION = "주문 등록";
    private static final String MAKE_PAYMENT = "결제하기";
    private static final String EXIT_APPLICATION = "프로그램 종료";

    private static final List<String> mainFeatures = new ArrayList<>();

    private MainFeatures() {
    }
    
    public static List<String> make() {
        mainFeatures.add(ORDER_REGISTRATION);
        mainFeatures.add(MAKE_PAYMENT);
        mainFeatures.add(EXIT_APPLICATION);
        return mainFeatures;
    }


}
