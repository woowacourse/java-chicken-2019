package domain.reserved;

import domain.Menu;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* 한 테이블의 예약을 가지 있다.*/
public class OrderedMenus {
    List<OrderedMenu> orderedMenus = new ArrayList<>();

    public boolean isExistMenu() {
        return orderedMenus.size() > 0;
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
        if (targetOrderedMenu.isPresent()) {
            return true;
        }
        return false;
    }

    public void addMenu(Menu menu) {
        orderedMenus.add(new OrderedMenu(menu));
    }

    public int  calcurateTotalPrice(){
        return orderedMenus.stream()
                .map(orderedMenu -> orderedMenu.getPrice())
                .reduce(Integer::sum)
                .get();
    }

    public void printOrderedMenu() {
        OutputView.printOrderedMenu(orderedMenus);
    }
}
