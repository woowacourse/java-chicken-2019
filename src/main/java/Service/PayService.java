package Service;

import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.HashMap;

public class PayService {
    public void pay(Table table) {
        HashMap<Menu, Integer> bill = table.getBill();
        OutputView.printOrderHistory(bill);

        int paymentMethod = InputView.inputPaymentMethod(table.getNumber());

        // 결제할 금액 출력
        // 결제되었습니다 메시지 출력
    }
}
