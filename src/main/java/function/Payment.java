package function;

import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 결제를 담당하는 클레스 입니다.
 * 입력한 테이블의 결제와 완료되면 해당 테이블의 value값을 0으로 초기화 합니다.
 */
public class Payment {
    static final List<Table> TABLES = TableRepository.tables();
    private int tableNumber;

    public void payment(){
        OutputView.printTablesPayment(TABLES,Order.tableMoney);
        tableNumber = InputView.inputPaymentTable();
        tableNumber = tableNumber -1;

        System.out.println("#최종 결제할 금액#");
        System.out.println(Order.tableMoney.get(TABLES.get(tableNumber)));

        Order.tableMoney.put(TABLES.get(tableNumber),0);
    }
}
