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
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        PoS pos = setupPoS(inputView, outputView);
        try {
            pos.handle();
        } catch (RuntimeException e) {
            outputView.printError(e);
            outputView.printExit();
            System.exit(-1);
        }

    }

    private static PoS setupPoS(InputView inputView, OutputView outputView) {
        TableService tableService = setupTableService(inputView, outputView);
        return new ChichenPoS(tableService, inputView, outputView);
    }

    private static TableService setupTableService(InputView inputView, OutputView outputView) {
        final List<Table> tables = TableRepository.tables();
        MenuService menuService = setupMenuService(outputView);
        return new TableServiceImpl(tables, menuService, inputView, outputView);
    }

    private static MenuService setupMenuService(OutputView outputView) {
        final List<Menu> menus = MenuRepository.menus();
        return new MenuServiceImpl(menus, outputView);
    }
}
