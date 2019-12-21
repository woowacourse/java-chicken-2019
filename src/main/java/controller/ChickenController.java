package controller;

import java.io.IOException;
import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import model.ChickenModel;

public class ChickenController {
    public static void playPos(List<Table> tables) throws IOException {
        final List<Menu> menus = MenuRepository.menus();
        ChickenModel model = new ChickenModel(tables,menus);
        model.startPos();
    }
}
