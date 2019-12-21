package domain.runner;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.List;

public class PayRunner {

    public static final int SELECT_NUMBER = 2;

    public static List<Table> tables = TableRepository.tables();
    public static List<Menu> menus = MenuRepository.menus();

    public static void runPay() {
    }
}
