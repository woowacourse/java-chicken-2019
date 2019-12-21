import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Purchase;
import domain.Table;
import domain.TableOrder;
import domain.TableRepository;
import domain.TotalOrders;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        final TotalOrders totalOrders = new TotalOrders();
        int inputCode = 0;
        while (inputCode != 3) {
            // 주문의 경우
            OutputView.printInitialFunction();
            inputCode = InputView.inputFunctionId(); // 이거에 따라서 기능 구현하는 인터페이스 만들어야 겠다.  // 주문

            OutputView.printTables(tables);
            final Table table = InputView.inputTable();

            OutputView.printMenus(menus);
            Menu menu = InputView.inputMenu();
            int menuQuantity = InputView.inputMenuQuantity();

            Order order = new Order(menu, menuQuantity);

            totalOrders.addOrder(table, order);
            // 이러고 다시 선택화면으로 돌아간다.

            //결제의 경우.
            Table table2 = InputView.inputTable();
            TableOrder tableOrder = totalOrders.getTableOrderByTable(table2);
            Purchase purchase = new Purchase(tableOrder);
            purchase.calculate();
            //해당 테이블의 주문 내역 가져온다.
            //메뉴,수량,금액\n
            //결제 객체가 결제 책임진다.   [TableOrder를 포함 하고 있을거야. ]
        }
        // 1번 과정에서 테이블 입력,
    }
}
