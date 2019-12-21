package domain.repository;

import domain.model.PayType;

import java.util.ArrayList;
import java.util.List;

public class PayRepository {
    private static final List<PayType> payTypes = new ArrayList<>();

    static {
        payTypes.add(PayType.CASH);
        payTypes.add(PayType.CARD);
    }

    public static PayType search(int typeNumber) {
        return payTypes.stream()
                .filter(x -> x.isSame(typeNumber))
                .findFirst()
                .orElse(null);
    }

    public static boolean isExist(int typeNumber) {
        return search(typeNumber) != null;
    }
}
