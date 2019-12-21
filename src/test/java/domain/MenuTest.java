package domain;

import static org.junit.jupiter.api.Assertions.*;

import annotation.TestDescription;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    @TestDescription("메뉴가 정상적으로 생성되고, getter가 잘 작동하는지 테스트합니다.")
    public void menuCreateTest() {
        Menu menu = new Menu(1, "시영치킨", Category.CHICKEN, 10000);
        assertEquals(menu.getName(), "시영치킨");
        assertEquals(menu.getNumber(), 1);
        assertEquals(menu.getPrice(), 10000);
    }

    @Test
    @TestDescription("메뉴가 존재하는지 검증하는 메서드가 잘 되는지 확인합니다.")
    public void existTest() {
        Menu menu = new Menu(1, "시영치킨", Category.CHICKEN, 10000);
        assertTrue(menu.isExist(1));
        assertFalse(menu.isExist(2));
    }

}