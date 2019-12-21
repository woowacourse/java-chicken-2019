package domain;

import java.util.List;

import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

public class Payment {
    int tableNumber;
    public Payment() {
        tableNumber = 0;
        pay();
        selectPayment(tableNumber);
    }

    public void pay() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        tableNumber = InputView.inputTablePayNumber();
        orderInformation(tableNumber);
    }

    public void orderInformation(int tableNumber) {
        System.out.println("##주문 내역");
        for (Order o : OrderList.search(tableNumber)) {
            System.out.println(o.getInformation());
        }
    }

    public void selectPayment(int tableNumber) {
        int select;

        OutputView.printSelectPayment(tableNumber);

        select =InputView.inputPayment();
        if (select == 1) {
            credit(tableNumber);
        }
        if (select == 2) {
            cash(tableNumber);
        }
    }

    public void credit(int tableNumber) {
        int total = total(tableNumber);
        OutputView.printTotal();
        System.out.println(total);
    }

    public void cash(int tableNumber) {
        OutputView.printTotal();
        System.out.println(((float)total(tableNumber) / 0.95));
    }

    public int total(int tableNumber) {
        int total = 0 ;
        for (Order o : OrderList.search(tableNumber)) {
            total += o.price();
        }
        return total;
    }
}

