package domain;

import java.util.List;

public class ChickenManager {
    private List<Menu> menus;
    private List<Table> tables;

    public ChickenManager(List<Menu> menus, List<Table> tables) {
        this.menus = menus;
        this.tables = tables;
    }

    public Table getTableByTableNumber(int tableNumber) {
        return tables.stream()
                .filter(s -> s.getNumber() == tableNumber)
                .findFirst()
                .get();
    }

    public Menu getMenuByMenuNumber(int menuNumber) {
        return menus.stream()
                .filter(s -> s.getNumber() == menuNumber)
                .findFirst()
                .get();
    }
}
