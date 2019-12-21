package com.github.callmewaggs.chickenpos.service;

import com.github.callmewaggs.chickenpos.domain.Table;
import com.github.callmewaggs.chickenpos.repository.TableRepository;
import com.github.callmewaggs.chickenpos.view.InputView;
import com.github.callmewaggs.chickenpos.view.OutputView;
import java.util.List;

public class TableService {

  public void showTables() {
    final List<Table> tables = TableRepository.getTables();
    OutputView.printTables(tables);
  }

  public int inputTableNumber() {
    return InputView.inputTableNumber();
  }

  public void markTable(int tableNumber) {
    TableRepository.markTable(tableNumber);
  }
}
