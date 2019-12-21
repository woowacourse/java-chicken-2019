package utils;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import javafx.application.Application;
import view.OutputView;

import java.io.InvalidObjectException;
import java.util.List;

public class OrderController {
    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();
    private final int tableNumber;

    public OrderController() throws InvalidObjectException {
        this.tableNumber = selectTable();
        orderMenu();
    }

    private int selectTable() throws InvalidObjectException {
        OutputView.printTables(tables);
        int tableNumber = SelectionHandeler.selectTable();
        if (tables.stream().noneMatch(x -> x.isCorrectTable(tableNumber))) {
            throw new InvalidObjectException("존재하지 않는 테이블입니다.");
        }
        return tableNumber;
    }

    private void orderMenu() throws InvalidObjectException {
        OutputView.printMenus(menus);
        int menuNumber = SelectionHandeler.selectMenu();
        if (menus.stream().noneMatch(x -> x.isCorrectMenu(menuNumber))) {
            throw new InvalidObjectException("존재하지 않는 메뉴입니다.");
        }
        int menuAmount = SelectionHandeler.selectAmount();
        TableRepository.orderToTable(tableNumber, findMenu(menuNumber), menuAmount);
    }

    private Menu findMenu(int menuNumber) {
        return menus.stream().filter(x-> x.isCorrectMenu(menuNumber)).findFirst().get();
    }
}
