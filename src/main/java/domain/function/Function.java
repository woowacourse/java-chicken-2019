/*
 * @(#)Function.java 0.2 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package domain.function;

import domain.Table;

import java.util.List;

public class Function {
    protected final List<Table> tables;

    public Function(List<Table> tables) {
        this.tables = tables;
    }

    public void operateFunction() {}
}
