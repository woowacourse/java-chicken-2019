/*
 * @(#)POS.java     0.3 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

import domain.function.TerminateFunction;
import domain.menu.Menu;
import domain.function.Function;
import domain.table.Table;
import domain.function.OrderFunction;
import domain.function.PaymentFunction;

import java.util.ArrayList;
import java.util.List;

public class POS {
    private final List<Function> functions = new ArrayList<>();

    public POS(List<Table> tables, List<Menu> menus) {
        this.functions.add(new OrderFunction(tables, menus));
        this.functions.add(new PaymentFunction(tables));
        this.functions.add(new TerminateFunction(tables));
    }

    public Function selectFunction(int functionNumber) {
        return functions.get(functionNumber);
    }
}
