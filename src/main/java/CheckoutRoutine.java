import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CheckoutRoutine {
    public static void checkoutRoutine(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        if (!tables.get(tableNumber).hasOrder()) {
            System.out.println("해당 테이블의 주문 내역이 없습니다.");
            return ;
        }
        tables.get(tableNumber).startCheckout();
    }
}
