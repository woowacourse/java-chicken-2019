import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        while (true) {
            OutputView.printMainFeatures();
            MainFeatureNumber mainFeatureNumber = InputView.getMainFeatureNumber();
            if (mainFeatureNumber.isExit()) {
                System.out.println("포스 프로그램이 종료되었습니다.");
                break;
            }
            if (mainFeatureNumber.isOrder()) {
                order(tables);
            }
            if (mainFeatureNumber.isPay()) {
                OutputView.printTables(tables);
            }
        }
    }

    private static void order(List<Table> tables) {
        OutputView.printTables(tables);
        final TableNumber tableNumber = InputView.getTableNumber();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        MenuNumber menuNumber = InputView.getMenuNumber();
        MenuCount menuCount = InputView.getMenuCount();
        TableRepository.addOrderToTable(tableNumber, menuNumber, menuCount);
    }
}
