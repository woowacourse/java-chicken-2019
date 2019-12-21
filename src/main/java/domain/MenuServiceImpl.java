package domain;

import java.util.List;
import java.security.InvalidParameterException;

import view.OutputView;

public class MenuServiceImpl implements MenuService {

    private List<Menu> menus;

    public MenuServiceImpl(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public void showMenues() {
        OutputView.printMenus(menus);
    }

    @Override
    public Menu getMenuByNumber(int menuNumber) {
        for (Menu menu : menus) {
            if (menu.isTarget(menuNumber)) {
                return menu;
            }
        }

        throw new InvalidParameterException("해당 메뉴가 존재하지 않습니다.");
    }
}
