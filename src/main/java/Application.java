import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.reserved.OrderStatement;
import order.Order;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OrderStatement orderStatement = new OrderStatement();
        Order oder = new Order();
        oder.startOrder(orderStatement);
    }
}
