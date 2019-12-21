package view;

import domain.Main;
import domain.MainRepository;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LINE = "\n";

    private static InputCheck inputCheck = new InputCheck();

    public static int inputMainNumber() {
        String inputNumberString;
        do {
            final List<Main> mains = MainRepository.mains();
            OutputView.printMains(mains);
            
            System.out.println(LINE + "## 원하는 기능을 선택하세요.");
            inputNumberString = scanner.nextLine();
        }while (inputCheck.numberCheck(inputNumberString));

        return Integer.parseInt(inputNumberString);
    }

    public static int inputTableNumber() {
        System.out.println(LINE + "## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println(LINE + "## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuQuantity(){
        System.out.println(LINE + "## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
}
