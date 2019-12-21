package model;

import java.io.IOException;
import java.util.List;

import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

public class ChickenModel {
    private List<Table> tables;
    private List<Menu> menus;


    public ChickenModel(List<Table> tables, List<Menu> menus) {
        this.tables = tables;
        this.menus = menus;
    }


    public void startPos() throws IOException {
        inputFunctionNumber();
        inputTableNumber();
    }

    private void inputTableNumber() throws IOException {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        OutputView.printMenus(menus);
    }

    private void inputFunctionNumber() throws IOException {
        OutputView.printMainFunctions();
        int functionNumber = InputView.inputFunctionNumber();
    }
}
