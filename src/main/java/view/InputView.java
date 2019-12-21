package view;


public class InputView {
    private static final String MAIN_MENU = "## 메인화면";
    private static final String MAIN_MENU_ORDER = "1 - 주문등록";
    private static final String MAIN_MENU_PAYMENT = "2 - 결제하기";
    private static final String MAIN_MENU_EXIT = "3 - 프로그램 종료";
    private static final String INPUT_TABLE_NUMBER = "## 테이블을 선택하세요.";
    private static final String INPUT_MENU_NUMBER = "## 등록할 메뉴를 선택하세요.";
    private static final String INPUT_HOW_MANY = "## 메뉴의 수량을 입력하세요.";
    private final static int MATCH_INDEX_WITH_INPUT = 1;

    public static int inputMainMenu() {
        System.out.println(MAIN_MENU);
        System.out.println(MAIN_MENU_ORDER);
        System.out.println(MAIN_MENU_PAYMENT);
        System.out.println(MAIN_MENU_EXIT);
        return InputCatcher.isInt();
    }

    public static int inputTableNumber() {
        System.out.println(INPUT_TABLE_NUMBER);
        return InputCatcher.isInt() - MATCH_INDEX_WITH_INPUT;
    }

    public static int inputMenuNumber() {
        System.out.println(INPUT_MENU_NUMBER);
        return InputCatcher.isInt() - MATCH_INDEX_WITH_INPUT;
    }

    public static int inputHowManyMenu() {
        int howMany;
        do {
            System.out.println(INPUT_HOW_MANY);
            howMany = InputCatcher.isInt();
        } while (InputCatcher.isOverHundred(howMany));

        return howMany;
    }

}
