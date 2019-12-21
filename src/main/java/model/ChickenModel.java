package model;

import java.io.IOException;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;
import domain.ChickenManager;
import domain.Menu;
import domain.Table;
import view.InputView;
import view.OutputView;

public class ChickenModel {
    private static final int REGISTER = 1;
    private List<Table> tables;
    private List<Menu> menus;
    private ChickenManager chickenManager;


    public ChickenModel(List<Table> tables, List<Menu> menus) {
        this.tables = tables;
        this.menus = menus;
        chickenManager = new ChickenManager(menus, tables);
    }


    public void startPos() throws IOException {
        int function = inputFunctionNumber();
        if(function==REGISTER){
            int tableNumber = inputTableNumber();
            int menuNumber = inputMenuNumber();
            int howMany = inputHowMany();
            setMenu(tableNumber,menuNumber,howMany);
        }
    }

    private void setMenu(int tableNumber, int menuNumber, int howMany) {
        Table table = chickenManager.getTableByTableNumber(tableNumber);
        Menu menu = chickenManager.getMenuByMenuNumber(menuNumber);
        for(int i=0; i<howMany; i++){
            table.addMenu(menu);
        }
    }

    private int inputHowMany() throws IOException {
        return InputView.inputHowMany();
    }

    private int inputMenuNumber() throws IOException {
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber(menus);
    }

    private int inputTableNumber() throws IOException {
        OutputView.printTables(tables);
        return InputView.inputTableNumber(tables);

    }

    private int inputFunctionNumber() throws IOException {
        OutputView.printMainFunctions();
        return InputView.inputFunctionNumber();
    }
}
