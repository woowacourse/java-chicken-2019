/*
 * @(#)POS.java     0.1 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

import domain.Function;

import java.util.ArrayList;
import java.util.List;

public class POS {
    private final List<Function> functions;

    public POS() {
        this.functions = new ArrayList<>();
    }

    public Function selectFunction(int functionNumber) {
        return functions.get(functionNumber - 1);
    }
}
