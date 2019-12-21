package domain;

import java.util.List;

/**
 * @author KIMSIYOUNG
 * @apiNote 테이블 번호와, 메뉴 번호로 쉽게 테이블객체와 메뉴 객체를 찾아주는 매니저 클래스입니다.
 */
public class ChickenManager {
    private List<Menu> menus;
    private List<Table> tables;

    public ChickenManager(List<Menu> menus, List<Table> tables) {
        this.menus = menus;
        this.tables = tables;
    }

    public Table getTableByTableNumber(int tableNumber) {
        return tables.stream()
                .filter(s -> s.getNumber() == tableNumber)
                .findFirst()
                .get();
    }

    public Menu getMenuByMenuNumber(int menuNumber) {
        return menus.stream()
                .filter(s -> s.getNumber() == menuNumber)
                .findFirst()
                .get();
    }
}
