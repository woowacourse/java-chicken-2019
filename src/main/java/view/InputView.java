package view;

import domain.Main;
import domain.MainRepository;
import domain.Menu;
import domain.Table;

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

    public static int inputTableNumber(List<Table> tables) {
        do {
            OutputView.printTables(tables);

            System.out.println(LINE + "## 테이블을 선택하세요.");
            inputNumberString = scanner.nextLine();
        } while (inputCheck.tableInputCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }

    public static int inputMenuNumber(List<Menu> menus) {
        do {
            OutputView.printMenus(menus);
            System.out.println(LINE + "## 등록할 메뉴를 선택하세요.");
            inputNumberString = scanner.nextLine();
        } while (inputCheck.tableInputCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }

    public static int inputMenuQuantity() {
        do {
            System.out.println(LINE + "## 메뉴의 수량을 입력하세요.");
            inputNumberString = scanner.nextLine();
        } while (inputCheck.menuInputCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }

    public static int inputPayment() {
        do {
            System.out.println(LINE + "## 신용 카드는 1번, 현금은 2번");
            inputNumberString = scanner.nextLine();
        } while (inputCheck.numberCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }
}
