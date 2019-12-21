package view;


public class InputView {

    public static int inputMainMenu() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        return InputCatcher.isInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return InputCatcher.isInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return InputCatcher.isInt();
    }

    public static int inputHowManyMenu() {
        int howMany;
        do {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            howMany = InputCatcher.isInt();
        } while (InputCatcher.isOverHundred(howMany));

        return howMany;
    }

}
