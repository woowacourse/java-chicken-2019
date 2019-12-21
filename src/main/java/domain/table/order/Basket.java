package domain.table.order;

import domain.menu.Menu;

public class Basket {

    private Menu menu;
    private CountMenu countMenu;

    public Basket(final Menu menu, final Integer countMenu) {
        this.menu = menu;
        this.countMenu = new CountMenu(countMenu);
    }

    public Integer getCountMenuNumber() {
        return countMenu.getCount();
    }

    public boolean isSameMenu(Basket basket) {
        return this.menu.isSameMenu(basket.menu);
    }

    public void plusCountMenu(Integer integer) {
        int editCount = countMenu.getCount() + integer;
        countMenu.setCount(editCount);
    }

    public Integer getCharge() {
        return menu.getPrice() * countMenu.getCount();
    }

    @Override
    public String toString() {
        return menu.getName() + " " + countMenu + " " + getCharge();
    }

}
