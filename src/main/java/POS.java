/*
 * @(#)POS.java     0.2 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

import domain.function.Function;
import domain.Table;
import domain.function.OrderFunction;
import domain.function.PaymentFunction;

import java.util.ArrayList;
import java.util.List;

public class POS {
    private final List<Table> tables;
    private final List<Function> functions = new ArrayList<>();

    public POS(List<Table> tables) {
        this.tables = tables;
        this.functions.add(new OrderFunction(tables));
        this.functions.add(new PaymentFunction(tables));
    }

    public Function selectFunction(int functionNumber) {
        return functions.get(functionNumber - 1);
    }
}
