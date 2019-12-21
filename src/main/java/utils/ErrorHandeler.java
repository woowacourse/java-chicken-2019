package utils;

import com.sun.jmx.remote.util.OrderClassLoaders;

import java.io.InvalidObjectException;

public class ErrorHandeler {
    public static OrderController makeOrderController() {
        try {
            return new OrderController();
        } catch (InvalidObjectException e) {
            System.out.println("\n## 주문 중 오류가 발생했습니다. 사유: " + e.getMessage());
            return makeOrderController();
        }

    }
}
