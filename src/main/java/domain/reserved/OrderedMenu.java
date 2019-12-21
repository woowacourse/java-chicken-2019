package domain.reserved;

import domain.Category;
import domain.Menu;

/*예약된 메뉴 하나를 가지고 있다.*/
public class OrderedMenu extends Menu {
    public OrderedMenu(int number, String name, Category category, int price) {
        super(number, name, category, price);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean isMatch(int number) {
        return super.isMatch(number);
    }
}
