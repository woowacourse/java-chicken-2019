/*
 * @(#)Application.java     0.1 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

import domain.function.Function;
import domain.function.TerminateFunction;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        POS pos = new POS(tables, menus);

        while (true) {
            OutputView.printFunctions();
            final int functionNumber = getInputFunctionNumber();
            final Function selectedFunction = pos.selectFunction(functionNumber - 1);

            selectedFunction.operateFunction();
            if (selectedFunction.getClass() == TerminateFunction.class) {
                break;
            }
        }
    }

    private static int getInputFunctionNumber() {
        try {
            final int functionNumber = InputView.inputFunctionNumber();
            return isValid(functionNumber);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputFunctionNumber();
        }
    }

    private static int isValid(int functionNumber) {
        if (functionNumber > 3 || functionNumber < 1) {
            throw new IllegalArgumentException("입력한 기능 목록이 존재하지 않습니다. 1부터 3까지의 숫자만 입력 가능합니다.");
        }
        return functionNumber;
    }
}
