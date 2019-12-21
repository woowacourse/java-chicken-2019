package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ApplicationSupporter {
    private static final int ADD_MENU = 1;
    private static final int CHECK_OUT = 2;
    private static final int END_PROGRAM = 3;

    private static MenuRepository menu = new MenuRepository();
    private static List<Menu> menuList;
    private static TableRepository table = new TableRepository();
    private static List<Table> tableList;

    public ApplicationSupporter() {
        menuList = menu.menus();
        tableList = table.tables();
    }

    public void mainOptionPhase() {
        OutputView.printMainOption();
        final int optionChoice = InputView.inputMainOption();
        if (optionChoice == ADD_MENU) {
            addMenuPhase();
        }
        if (optionChoice == CHECK_OUT) {
            checkOutPhase();
        }
        if (optionChoice == END_PROGRAM) {
            OutputView.printEndMessage();
            System.exit(0);
        }
    }

    public void addMenuPhase() {
        OutputView.printTables(tableList);

        final int tableNumber = InputView.tableChecker(tableList); // 테이블 번호 유효 검사
        OutputView.printMenus(menuList);

        final int menuNumber = InputView.inputAddMenu();
        final int menuQuantity = InputView.inputCountMenu();
        Menu choiceMenu = choiceMenuTrans(menuNumber);
        Table choiceTable = findTable(tableNumber);
        choiceTable.makeOrder(choiceMenu, menuQuantity);

        mainOptionPhase();
    }

    public Table findTable(int input) {
        return tableList.stream().filter(x -> x.tableMatch(input))
                .findAny().orElseThrow(Error::new);
    }

    public Menu choiceMenuTrans(int input) {
        return menuList.stream().filter(x -> x.matchNumber(input))
                .findAny().orElseThrow(Error::new);
    }

    public void checkOutPhase() {
        OutputView.printTables(tableList);
        final int tableNumber = InputView.tableChecker(tableList);
        Table choiceTable = findTable(tableNumber);
        orderCheck(choiceTable);
        orderResult(choiceTable.getOrder(), menuList);

        // 최종 결제, 할인, 객체 클리어
        mainOptionPhase();
    }

    public void orderCheck(Table table) {
        if (!table.isOrder()) {
            OutputView.printTableChoiceError();
            checkOutPhase();
        }
    }

    public void orderResult(HashMap<String, Integer> order, List<Menu> tableMenu) {
        OutputView.printOrderForCheckOut();
        int total = 0;
        for (String key : order.keySet()) {
            Menu thisMenu = tableMenu.stream().filter(x -> x.matchName(key))
                    .findFirst().orElseThrow(Error::new);
            System.out.println(key + " " + order.get(key)
                    + " " + thisMenu.getPrice() * order.get(key));
            total += thisMenu.getPrice() * order.get(key);
        }
        OutputView.printResult(total);
    }

}
