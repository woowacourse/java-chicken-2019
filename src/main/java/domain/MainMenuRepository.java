package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMenuRepository {
    private static final List<MainMenu> mainMenus = new ArrayList<>();

    static {
        mainMenus.add(new MainMenu(1, "주문등록"));
        mainMenus.add(new MainMenu(2, "결제하기"));
        mainMenus.add(new MainMenu(3, "프로그램 종료"));
    }

    public static List<MainMenu> mainMenus() {
        return Collections.unmodifiableList(mainMenus);
    }

}
