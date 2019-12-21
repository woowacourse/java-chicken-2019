package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import annotation.TestDescription;
import org.junit.jupiter.api.Test;

class TableTest {

    @Test
    @TestDescription("같은 메뉴를 추가하는 경우 메뉴가 갱신되지 않고, 기존 메뉴에서 count 만 올라갑니다.")
    public void createTest(){
        List<Table> tables = TableRepository.tables();
        List<Menu> menus = MenuRepository.menus();
        tables.get(0).addMenu(tables.get(0),menus.get(0),50);
        assertTrue(tables.get(0).hasMenu());
        tables.get(0).addMenu(tables.get(0),menus.get(0),49);

        double money = tables.get(0).getTotalMoneyWithPayment(Payment.CREDIT_CARD);

        assertTrue(tables.get(0).getMenus().size()==1);
        assertFalse(tables.get(0).getMenus().size()==2);
    }
}