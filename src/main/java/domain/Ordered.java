package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ordered {
    private static final int CHICKEN_DISCOUNT_MIN_SIZE = 10;
    private static final int CHICKEN_DISCOUNT_VALUE = 10000;

    private List<Menu> orderedMenus = new ArrayList<>();

    public Ordered() {
    }

    public void addMenu(Menu menu, int amount) {
        IntStream.range(0, amount).forEach(x -> orderedMenus.add(menu));
    }

    public Map<String, List<Menu>> amountMenu() {
        return orderedMenus.stream().collect(Collectors.groupingBy(Menu::getName));
    }

    public int chickensDiscount() {
        Map<Category, List<Menu>> categoryGroupedMenu = orderedMenus.stream()
                .collect(Collectors.groupingBy(Menu::getCategory));
        int chickenAmount = categoryGroupedMenu.get(Category.CHICKEN).size();
        return (chickenAmount / CHICKEN_DISCOUNT_MIN_SIZE) * CHICKEN_DISCOUNT_VALUE;
    }

    public int allPrices() {
        return orderedMenus.stream()
                .map(Menu::getPrice)
                .reduce(Integer::sum)
                .orElse(0) - chickensDiscount();
    }
}
