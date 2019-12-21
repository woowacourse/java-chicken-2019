package service;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderedMenu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderRegistor extends Service{
    private List<Table> tables;

    public OrderRegistor(int number, String name) {
        super(number, name);
    }

    public void run(List<Table> tables){
        int tableNumber;
        int menuNumber;
        int menuQuantity;

        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(MenuRepository.menus());
        menuNumber =InputView.inputMenuNumber();
        menuQuantity =  InputView.inputMenuQuantity();

    }


}
