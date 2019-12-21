package service;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderedMenu;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderRegistor extends Service{

    public OrderRegistor(int number, String name) {
        super(number, name);
    }


    public void run(List<Table> tables){
        Table table;
        OrderedMenu orderedMenu;

        OutputView.printTables(tables);
        table = getTable(tables,InputView.inputTableNumber());
        OutputView.printMenus(MenuRepository.menus());
        orderedMenu = new OrderedMenu(getMenu(InputView.inputMenuNumber()),InputView.inputMenuQuantity());

        table.addMenu(orderedMenu);
    }

    private Menu getMenu(int menuNumber){
        for(Menu menu : MenuRepository.menus()){
            if(menu.equals(menuNumber)){
                return menu;
            }
        }
        return null;
    }

    private Table getTable(List<Table> tables, int tableNumber){
        for(Table table : tables){
            if(table.equals(tableNumber)){
                return table;
            }
        }
        return null;
    }

}
