package domain;

import view.OutputView;

import java.security.InvalidParameterException;
import java.util.List;

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
                return  menu;
            }
        }

        throw new InvalidParameterException("해당 메뉴가 존재하지 않습니다.");
    }
}
