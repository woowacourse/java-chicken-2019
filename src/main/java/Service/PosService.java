package Service;

import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosService {
    private static final int ORDER = 1;
    private static final int PAY = 2;

    public void run(int nextStep) {
        OrderService orderService = new OrderService();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        Table selectedTable = selectTable(tables, tableNumber);

        if (nextStep == ORDER) {
            orderService.order(selectedTable);
        }
        if (nextStep == PAY) {
            // 테이블 목록 출력
            // 테이블 선택
            // 주문내역 출력
            // 결제 방식 선택
            // 결제할 금액 출력
            // 결제되었습니다 메시지 출력
        }
    }

    private Table selectTable(List<Table> tables, int number) {
        return tables.stream()
                .filter(table -> table.isSameTableNumber(number))
                .findFirst()
                .get();
    }
}
