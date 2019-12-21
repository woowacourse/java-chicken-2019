package com.github.callmewaggs.chickenpos.domain;

import com.github.callmewaggs.chickenpos.view.InputView;
import com.github.callmewaggs.chickenpos.view.OutputView;
import java.util.List;

public class MenuService {

  public void showMenus() {
    final List<Menu> menus = MenuRepository.menus();
    OutputView.printMenus(menus);
  }

  public int inputMenuNumber() {
    return InputView.inputMenuNumber();
  }

  public int inputMenuAmount() {
    return InputView.inputMenuAmount();
  }
}
