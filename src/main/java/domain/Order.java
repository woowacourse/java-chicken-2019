package domain;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.Order;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Order {
    private static final String name = "주문하기";

    public Order() {
        System.out.println(tmp);
    }

    public int SelectTable() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        return tableNumber;
    }

    public String getName() {
        return name;
    }

}
