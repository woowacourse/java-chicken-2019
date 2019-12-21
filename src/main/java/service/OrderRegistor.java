package service;

import domain.Table;
import view.OutputView;

import java.util.List;

public class OrderRegistor extends Service{
    private List<Table> tables;

    public OrderRegistor(int number, String name) {
        super(number, name);
    }

    public void run(List<Table> table){
        OutputView.printTables(tables);

    }
}
