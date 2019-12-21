package function;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 주문등록 기능을 할때 해당클레스를 사용합니다.
 */
public class Order {
    static final List<Table> TABLES = TableRepository.tables();
    static Map<Table,Integer> tableMoney= new HashMap<>();

    /**
     * 생성자로 table과 table의 계산 금액을 갖는 hashMap을 초기화 합니다.
     */
    public Order(){
        for (Table table : TABLES) {
            tableMoney.put(table, 0);
        }
    }

    /**
     * 주문 등록 기능을 할때 테이블번호, 메뉴등록, 메뉴수량을 입력하는 메소드를 실행합니다.
     */
    public static void orderTable() {
        OutputView.printTables(TABLES);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.InputMenu();
        final int MenuQuantity = InputView.MenuQuantity();
    }

}
