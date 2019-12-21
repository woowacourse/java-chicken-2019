package com.github.callmewaggs.chickenpos.domain;

import com.github.callmewaggs.chickenpos.view.InputView;
import com.github.callmewaggs.chickenpos.view.OutputView;
import java.util.List;

public class TableService {

  public void showTables() {
    final List<Table> tables = TableRepository.tables();
    OutputView.printTables(tables);
  }

  public int inputTableNumber() {
    return InputView.inputTableNumber();
  }
}
