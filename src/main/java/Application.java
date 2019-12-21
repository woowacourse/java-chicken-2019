import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.runner.OrderRunner;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        List<Table> tables = TableRepository.tables();
        List<Menu> menus = MenuRepository.menus();
        OrderRunner.runOrder(tables, menus);
        OrderRunner.runOrder(tables, menus);

    }
}
