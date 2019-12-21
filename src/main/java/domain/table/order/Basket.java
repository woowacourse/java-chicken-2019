package domain.table.order;

import domain.menu.Category;
import domain.menu.Menu;

public class Basket {

    private static final int BUNDLE_DISCOUNT_AMOUNT = 10000;
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
        int initCharge = menu.getPrice() * countMenu.getCount();
        if (menu.getCategory() == Category.CHICKEN)
            return applyBundleDiscount(initCharge);
        return initCharge;
    }

    private Integer applyBundleDiscount(int initCharge) {
        int bundleDiscount = countMenu.getCount() / 10;
        return initCharge - bundleDiscount * BUNDLE_DISCOUNT_AMOUNT;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + countMenu + " " + getCharge();
    }

}
