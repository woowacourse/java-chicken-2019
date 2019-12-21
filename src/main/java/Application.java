import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printMainFeatures();
        MenuFeatureNumber menuFeatureNumber = InputView.inputMenuFeatureNumber();
        if (menuFeatureNumber.isExit()) {
            System.out.println("포스 프로그램이 종료되었습니다.");
            return;
        }
        if (menuFeatureNumber.isOrder()) {
            OutputView.printTables(tables);
        }
        if (menuFeatureNumber.isPay()) {
            OutputView.printTables(tables);
        }

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
