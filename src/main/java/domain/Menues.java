package domain;

import java.util.List;

public class Menues {
    private final List<Menu> menues;

    public Menues(List<Menu> menues) {
        this.menues = menues;
    }

    public int chickenSize() {
        return (int) menues.stream()
                .filter(Menu::isChicken)
                .count();
    }

    public int getPrice() {
        return menues.stream()
                .map(Menu::getPrice)
                .reduce(0, Integer::sum);
    }

}
