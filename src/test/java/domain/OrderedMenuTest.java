package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import annotation.TestDescription;
import org.junit.jupiter.api.Test;

class OrderedMenuTest {

    @Test
    public void OrderedMenuGetterTest(){
        List<Table> tables = TableRepository.tables();
        List<Menu> menus = MenuRepository.menus();
        OrderedMenu menu = new OrderedMenu(tables.get(0),menus.get(0),30);

        assertEquals(menu.getCount(),30);
        assertEquals(menu.getMenuId(),1);
    }

    @Test
    @TestDescription("같은 메뉴에 대해, 99이상 가질 수 없다는 것을 테스트합니다.")
    public void canHaveMoreTest(){
        List<Table> tables = TableRepository.tables();
        List<Menu> menus = MenuRepository.menus();
        OrderedMenu menu = new OrderedMenu(tables.get(0),menus.get(0),30);

        assertTrue(menu.canOrderMore(69));
        assertFalse(menu.canOrderMore(70));
    }

    @Test
    @TestDescription("치킨인지 아닌지를 판단하는 메소드를 테스트합니다.(menus.get(0)값은 치킨입니다.)")
    public void isChickenTest(){
        List<Table> tables = TableRepository.tables();
        List<Menu> menus = MenuRepository.menus();
        OrderedMenu menu = new OrderedMenu(tables.get(0),menus.get(0),30);
        boolean chicken = menu.isChicken(menu.getMenuId());

        assertTrue(chicken);
        assertEquals(menu.getCount(),30);
    }
}