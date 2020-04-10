package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TableTest {

    @Test
    void registerMenu() {
        Table table = new Table(1);

        Menu testMenu1 = new Menu(1, "가짜메뉴1", Category.CHICKEN, 1_000);
        Menu testMenu2 = new Menu(2, "가짜메뉴2", Category.CHICKEN, 1_3990);

        table.registerMenu(testMenu1, 1);
        table.registerMenu(testMenu1, 1);
        table.registerMenu(testMenu2, 3);

        Map<Menu, Integer> expected = new HashMap<>();
        expected.put(testMenu1, 2);
        expected.put(testMenu2, 3);

        assertThat(table.getOrderHistory()).isEqualTo(expected);
    }
}