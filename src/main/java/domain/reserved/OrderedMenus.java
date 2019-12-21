package domain.reserved;

import domain.Menu;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderedMenus {
    private static final int ZERO = 0;
    private final List<OrderedMenu> orderedMenus = new ArrayList<>();

    public boolean isExistMenu() {
        return orderedMenus.size() > ZERO;
    }

    public OrderedMenu getMenuBy(int menuId) {
        return orderedMenus.stream()
                .filter(orderedMenu -> orderedMenu.isMatch(menuId))
                .findFirst()
                .get();
    }

    public boolean isExistBy(int menuId) {
        Optional<OrderedMenu> targetOrderedMenu = orderedMenus.stream()
                .filter(orderedMenu -> orderedMenu.isMatch(menuId))
                .findFirst();
        return targetOrderedMenu.isPresent();
    }

    public void addMenu(Menu menu, int capacity) {
        orderedMenus.add(new OrderedMenu(menu, capacity));
    }


    public int calcurateTotalPrice() {
        return orderedMenus.stream()
                .map(OrderedMenu::getTotalPrice)
                .reduce(Integer::sum)
                .get();
    }

    public void printOrderedMenu() {
        OutputView.printOrderedMenu(orderedMenus);
    }

    public int calcurateChickenCount() {
        return orderedMenus.stream()
                .filter(OrderedMenu::isChicken)
                .map(orderedMenu -> orderedMenu.getCapacity().getCapacity())
                .reduce(Integer::sum)
                .get();
    }
}
