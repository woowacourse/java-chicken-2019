package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author KIMSIYOUNG
 * @apiNote 주문한, 메뉴의 정보를 골라보기 위한 주문된메뉴 클래스입니다.
 * @since 2019-12-21
 */
public class OrderedMenu {
    private static final int SEVEN = 7;
    private static final int MAX_ORDER = 99;

    private Table table;
    private Menu menu;
    private int count;

    public OrderedMenu(Table table, Menu menu, int count) {
        this.table = table;
        this.menu = menu;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getMenuId() {
        return menu.getNumber();
    }

    public boolean canOrderMore(int howMany) {
        return count + howMany <= MAX_ORDER;
    }

    public double sumOfEachMenu() {
        return menu.getPrice() * count;
    }

    public boolean isChicken(int menuNumber) {
        List<Integer> chickenList = new ArrayList<>();
        for (int i = 1; i < SEVEN; i++) {
            chickenList.add(i);
        }
        return chickenList.contains(menuNumber);
    }

    public void addJustCount(int howMany) {
        count += howMany;   //  같은 메뉴인 경우, 수량만을 증가 시키기 위한 메서드입니다.
    }

    @Override
    public String toString() {
        return menu.getName() + ", 수량 : " + count + " 가격 : " + menu.getPrice() * count;
    }

    @Override
    public boolean equals(Object o) {   //  같은 메뉴인지를, 판별하기 위해 Count 변수 제외하고 비교하는 equals입니다.
        if (this == o) return true;
        if (!(o instanceof OrderedMenu)) return false;
        OrderedMenu that = (OrderedMenu) o;
        return table.equals(that.table) &&
                menu.equals(that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, menu);
    }
}
