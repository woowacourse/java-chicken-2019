package controller;

import java.io.IOException;
import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import view.InputView;
import view.OutputView;

public class ChickenController {
    public static void playPos() throws IOException {
        InputView.inputFunctionNumber();
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
