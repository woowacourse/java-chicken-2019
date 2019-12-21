/*
 * @(#)Application.java 2019/12/21
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

import java.util.List;

import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PoS pos = setupPoS(inputView);
        try {
            pos.handle();
        } catch (RuntimeException e) {
            OutputView.printError(e);
            OutputView.printExit();
            System.exit(-1);
        }

    }

    private static PoS setupPoS(InputView inputView) {
        TableService tableService = setupTableService(inputView);
        return new ChichenPoS(tableService, inputView);
    }

    private static TableService setupTableService(InputView inputView) {
        final List<Table> tables = TableRepository.tables();
        MenuService menuService = setupMenuService();
        return new TableServiceImpl(tables, menuService, inputView);
    }

    private static MenuService setupMenuService() {
        final List<Menu> menus = MenuRepository.menus();
        return new MenuServiceImpl(menus);
    }
}
