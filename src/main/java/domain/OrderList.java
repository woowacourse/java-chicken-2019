package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class OrderList {
    private final LinkedHashMap<Menu, Integer> orderList;

    public OrderList() {
        final List<Menu> menus = MenuRepository.menus();
        orderList = new LinkedHashMap<>();
        for (Menu menu : menus) {
            orderList.put(menu, 0);
        }
    }

    public void addOrderList(MenuNumber menu) {
        Integer value = orderList.get(menu.getMenu());
        value += menu.getNumberOfMenu();
        orderList.put(menu.getMenu(), value);
    }

    public void printOrderList() {
        Set<Map.Entry<Menu, Integer>> set = orderList.entrySet();
        Iterator<Map.Entry<Menu, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Menu, Integer> entry = iterator.next();
            Menu tmp1 = entry.getKey();
            Integer tmp2 = entry.getValue();
            if (tmp2 != 0) {
                System.out.println(tmp1.getName() + " " + tmp2 + " "
                        + tmp1.getPrice() * tmp2);
            }
        }
    }

    public int calculatePriceSum(TypeOfPayment payment) {
        int sum = 0;
        int numberOfChicken = 0;
        Set<Map.Entry<Menu, Integer>> set = orderList.entrySet();
        Iterator<Map.Entry<Menu, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Menu, Integer> entry = iterator.next();
            if (entry.getKey().isChicken()) {
                numberOfChicken += entry.getValue();
            }
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return calculateDiscount(sum, numberOfChicken, payment);
    }

    public int calculateDiscount(int sum, int numberOfChicken,
                                 TypeOfPayment payment) {
        sum -= ((numberOfChicken / 10) * 10000);
        if (payment.isCash()) {
            sum *= 0.95;
        }
        return sum;
    }
}
