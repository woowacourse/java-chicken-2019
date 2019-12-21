package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ApplicationSupporter {
    private static final int ADD_MENU = 1;
    private static final int CHECK_OUT = 2;
    private static final int END_PROGRAM = 3;
    private static final int CASH = 2;
    private static final int CHICKEN_DISCOUNT = 10000;
    private static final int CHICKEN_COUNT = 10;

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

        final int tableNumber = InputView.tableChecker(tableList);
        OutputView.printMenus(menuList);

        final int menuNumber = InputView.inputAddMenu();
        final int menuQuantity = InputView.inputCountMenu();
        Menu choiceMenu = choiceMenuTrans(menuNumber);
        Table choiceTable = findTable(tableNumber);
        choiceTable.makeOrder(choiceMenu, menuQuantity);
        chickenCount(choiceMenu, choiceTable, menuQuantity);

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

    public void chickenCount(Menu choiceMenu, Table choiceTable, int quantity) {
        if (choiceMenu.getCategory() == Category.CHICKEN) {
            choiceTable.addChickens(quantity);
        }
    }

    public void checkOutPhase() {
        OutputView.printTables(tableList);
        final int tableNumber = InputView.tableChecker(tableList);
        Table choiceTable = findTable(tableNumber);

        orderCheck(choiceTable);
        int tempCost = orderResult(choiceTable.getOrder(), menuList);
        calculateOrder(tempCost, choiceTable.getChickens(), tableNumber);
        choiceTable.checkOut();

        mainOptionPhase();
    }

    public void orderCheck(Table table) {
        if (!table.isOrder()) {
            OutputView.printTableChoiceError();
            checkOutPhase();
        }
    }

    public int orderResult(HashMap<String, Integer> order, List<Menu> tableMenu) {
        OutputView.printOrderForCheckOut();
        int totalCost = 0;
        for (String key : order.keySet()) {
            Menu thisMenu = tableMenu.stream().filter(x -> x.matchName(key))
                    .findFirst().orElseThrow(Error::new);
            System.out.println(key + " " + order.get(key)
                    + " " + thisMenu.getPrice() * order.get(key));
            totalCost += thisMenu.getPrice() * order.get(key);
        }
        return totalCost;
    }

    public void calculateOrder(int input, int chickens, int tableNumber) {
        OutputView.howToCheckOut(tableNumber);
        final int choice = InputView.inputHowToCheckOut();

        input = chickenDiscount(input, chickens);
        if (choice == CASH) {
            input = (int)(input * 0.95);
        }
        OutputView.printResult(input);
    }

    public int chickenDiscount(int input, int chickens) {
        for(int i = chickens; i >= 10; i -= CHICKEN_COUNT) {
            input -= CHICKEN_DISCOUNT;
        }
        return input;
    }
}
