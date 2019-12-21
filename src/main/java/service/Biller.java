package service;

import domain.Menu;
import domain.OrderedMenu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Biller extends Service {
    private final static double DISCOUNT_IF_CASH = 0.95;
    private final static int OPTION_NUMBER_OF_CAHS = 2;
    private final static int DISCOUNT_PRICE_PER_PAIR = 10000;
    private final static int AMOUNT_OF_CHICKEN_PAIR = 10;

    public Biller() {
        super(2, "결제하기");
    }

    public void run(List<Table> tables) {
        Table table;
        int totalPrice;

        OutputView.printTables(tables);
        table = getTable(tables, InputView.inputTableNumber());
        table.printOrderedMenu();
        OutputView.printStartCalculatingPrice(table);
        totalPrice = calculateTotalPrice(table, InputView.inputCardOrCash());
        OutputView.printTotalPrice(totalPrice);
        completePayment(table);

    }

    private Table getTable(List<Table> tables, int tableNumber) {
        for (Table table : tables) {
            if (table.equals(tableNumber)) {
                return table;
            }
        }
        return null;
    }

    private int calculateTotalPrice(Table table, int cardOrCash) {
        int totalPrice = table.getSumOfPrice();
        totalPrice = discountBecuaseCash(totalPrice,cardOrCash);
        totalPrice -= discountPriceBecauseChicken(table);
        return totalPrice;
    }

    private int discountPriceBecauseChicken(Table table) {
        return DISCOUNT_PRICE_PER_PAIR * (table.countTotalChicken() / AMOUNT_OF_CHICKEN_PAIR);
    }

    private int discountBecuaseCash(int price, int cardOrCash){
        if (cardOrCash == OPTION_NUMBER_OF_CAHS) {
            return (int) (price * DISCOUNT_IF_CASH);
        }
        return price;
    }
    private void completePayment(Table table){
        table.removeMenu();
    }

}
