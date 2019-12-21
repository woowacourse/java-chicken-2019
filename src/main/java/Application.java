import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuCategory = InputView.inputMenuCategory();
        final int menuCount = InputView.inputMenuCount();

        Order aa = new Order(tableNumber,menuCategory,menuCount);

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(tableNumber,menuCategory,menuCount));
        for (Order dd : orderList){
            System.out.printf("테이블 : %d 메뉴 : %d 수량 : %d",dd.tableNumber,dd.menuCategory,dd.menuCount);
        }
    }
}
