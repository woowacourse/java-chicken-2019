package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

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
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber(); // 테이블 번호 유효 검사
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputAddMenu();
        final int menuQuantity = InputView.inputCountMenu();
        Menu choiceMenu = choiceMenuTrans(menuNumber);
        Table choiceTable = findTable(tableNumber);
        choiceTable.makeOrder(choiceMenu, menuQuantity);

        System.out.println(choiceTable.getOrder());
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
        // 코드 추가 -> 결제 기능
        System.out.println(menuList);
    }

}
