package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderRegistor extends Service{
    private List<Table> tables;

    public OrderRegistor(int number, String name) {
        super(number, name);
    }

    public void run(List<Table> table){
        int tableNumber;

        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(MenuRepository.menus());

    }
}
