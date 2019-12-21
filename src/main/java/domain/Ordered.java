package domain;

import java.util.ArrayList;
import java.util.List;

public class Ordered {
    private List<Menu> orderedMenus = new ArrayList<>();

    public Ordered() {
    }

    public int allPrices() {
        return orderedMenus.stream()
                .map(Menu::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
