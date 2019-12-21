import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.reserved.OrderStatement;
import order.Order;
import payment.PaymentFeature;
import view.InputView;
import view.OutputView;
import view.dto.FeatureType;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OrderStatement orderStatement = new OrderStatement();
        while (inputFeatureType(orderStatement)) ;
        Order oder = new Order();
        oder.startOrder(orderStatement);
    }

    private static boolean inputFeatureType(OrderStatement orderStatement) {
        FeatureType featureType = InputView.inputSelectFeature();
        if (featureType.isTypeOrder()) {
            runOrder(orderStatement);
            return true;
        }
        if (featureType.isTypePayment()) {
            runPayment(orderStatement);
            return true;
        }
        System.out.println("종료");
        return false;
    }

    private static void runOrder(OrderStatement orderStatement) {
        Order oder = new Order();
        oder.startOrder(orderStatement);
    }

    private static void runPayment(OrderStatement orderStatement) {
        PaymentFeature paymentFeature = new PaymentFeature();
        paymentFeature.startPayment(orderStatement);
    }
}
