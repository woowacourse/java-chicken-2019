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

        OutputView.printMain();

        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        while(true) {
            final int mainDecision = InputView.inputMain();
            if (mainDecision == 1) {
                OutputView.printTables(tables);
                final int tableNumber = InputView.inputTableNumberForOrder();
                OutputView.printMenus(menus);
                continue;
            }
            if (mainDecision == 2) {
                continue;
            }
            if (mainDecision == 3) {
                System.out.println("## 프로그램을 종료합니다.");
                return;
            }
            System.out.println("원하는 기능은 1,2,3 중에 선택 가능합니다.");
            continue;
        }


    }
}
