package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ordered {
    private List<Menu> orderedMenus = new ArrayList<>();

    public Ordered() {
    }

    public void addMenu(Menu menu, int amount) {
        IntStream.range(0, amount).forEach(x -> orderedMenus.add(menu));
    }

    public int allPrices() {
        return orderedMenus.stream()
                .map(Menu::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
