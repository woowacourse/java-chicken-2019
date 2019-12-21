package utils;

import domain.*;
import view.OutputView;

import java.io.InvalidObjectException;
import java.util.List;

public class PaymentController {
    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();
    private final int tableNumber;


    public PaymentController() throws InvalidObjectException {
        this.tableNumber = selectTable();
        checkOutTable();
    }

    private int selectTable() throws InvalidObjectException {
        OutputView.printTables(tables);
        int tableNumber = SelectionHandeler.selectTable();
        if (tables.stream().noneMatch(x -> x.isCorrectTable(tableNumber))) {
            throw new InvalidObjectException("존재하지 않는 테이블입니다.");
        }
        return tableNumber;
    }

    private void checkOutTable() {
        Price price = .calculatePrice();

    }
}
