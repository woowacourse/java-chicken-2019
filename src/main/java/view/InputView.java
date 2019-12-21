package view;

import domain.*;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LINE = "\n";

    private static InputCheck inputCheck = new InputCheck();
    private static String inputNumberString;

    public static int inputMainNumber() {
        do {
            final List<Main> mains = MainRepository.mains();
            OutputView.printMains(mains);

            System.out.println(LINE + "## 원하는 기능을 선택하세요.");
            inputNumberString = scanner.nextLine();
        } while (inputCheck.mainInputCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }

    public static int inputTableNumber() {
        do {
            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);

            System.out.println(LINE + "## 주문할 테이블을 선택하세요.");
            inputNumberString = scanner.nextLine();
        } while (inputCheck.tableInputCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }

    public static int inputMenuNumber() {
        do {
            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);
            System.out.println(LINE + "## 등록할 메뉴를 선택하세요.");
            inputNumberString = scanner.nextLine();
        } while (inputCheck.tableInputCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }

    public static int inputMenuQuantity() {
        do{
            System.out.println(LINE + "## 메뉴의 수량을 입력하세요.");
            inputNumberString = scanner.nextLine();
        }while(inputCheck.numberCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }


}
