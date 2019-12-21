package main;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import function.Order;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 프로그램 처음 시작할때 케이스를 골라야 하는 클레스입니다.
 * 해당 클레스를 메인으로 모든 프로그램이 돌아갑니다.
 */
public class MainFunction {
    private int caseNumber;
    final static int ORDER = 1;
    final static int PAY = 2;
    final static int EXIT = 3;

    public void mainFunction() {
        caseNumber = InputView.inputMainFunction();
        while (caseNumber != EXIT) {
            Order.orderTable();
            caseNumber = InputView.inputMainFunction();
        }
    }
}
