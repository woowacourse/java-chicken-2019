package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private Table table;

    @BeforeEach
    void init() {
        this.table = new Table(1);
    }

    @Test
    void settleNotExccedsTen() {
        //given
        Menu chicken = new Menu(1, "후라이드", Category.CHICKEN, 100);
        Menu beverage = new Menu(2, "음료", Category.BEVERAGE, 10);
        table.takeOrder(chicken);
        table.takeOrder(beverage);

        assertEquals(100 + 10, table.settle(1));
        assertEquals((100 + 10) * MenuConfig.DISCOUNT_RATE, table.settle(2))  ;
    }

    @Test
    void settleExccedsTen() {
        //given
        int chikenMoney = 100;
        int beverageMoney = 10;
        Menu chicken = new Menu(1, "후라이드", Category.CHICKEN, chikenMoney);
        Menu beverage = new Menu(2, "음료", Category.BEVERAGE, beverageMoney);
        for (int i = 0; i < MenuConfig.STANDARD_NUMBER_TO_DISCOUNT;  i++) {
            table.takeOrder(chicken);
        }
        table.takeOrder(beverage);

        assertEquals((chikenMoney * MenuConfig.STANDARD_NUMBER_TO_DISCOUNT) + beverageMoney - MenuConfig.DISCOUNT_AMOUNT, table.settle(WayToPay.creditCard.getValue()));
        assertEquals(((chikenMoney * MenuConfig.STANDARD_NUMBER_TO_DISCOUNT) + beverageMoney - MenuConfig.DISCOUNT_AMOUNT) * MenuConfig.DISCOUNT_RATE, table.settle(WayToPay.cash.getValue()));

    }
}