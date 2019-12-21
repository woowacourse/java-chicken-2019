import domain.reserved.OrderStatement;
import order.Order;
import payment.PaymentFeature;
import view.InputView;
import view.OutputView;
import view.dto.FeatureType;

public class Application {
    public static void main(String[] args) {
        OrderStatement orderStatement = new OrderStatement();
        while (inputFeatureType(orderStatement)) ;
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
        OutputView.printClose();
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
