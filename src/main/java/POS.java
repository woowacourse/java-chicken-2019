/*
 * @(#)POS.java     0.3 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

import domain.Menu;
import domain.function.Function;
import domain.Table;
import domain.function.OrderFunction;
import domain.function.PaymentFunction;

import java.util.ArrayList;
import java.util.List;

public class POS {
    private final List<Table> tables;
    private final List<Function> functions = new ArrayList<>();

    public POS(List<Table> tables, List<Menu> menus) {
        this.tables = tables;
        this.functions.add(new OrderFunction(tables, menus));
        this.functions.add(new PaymentFunction(tables));
    }

    public Function selectFunction(int functionNumber) {
        return functions.get(functionNumber - 1);
    }
}
