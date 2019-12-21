package domain.store;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

/**
 * Store 클래스는 매장 전반의 운영을 담당하는 클래스이다.
 * 메뉴와 테이블을 포함하여 이들을 관리/운영하고,
 * 결제 객체를 통해 결제를 진행한다.
 * 입력에 따라 프로그램이 종료되면, 매장의 운영을 종료한다.
 */
public class Store {
    /**
     * tables는 테이블 객체를 모은 리스트이다.
     * tableRepository객체를 통해 생성된다.
     */
    private final List<Table> tables;

    /**
     * menus는 메뉴 객체를 모은 리스트이다.
     * menuRepository객체를 통해 생성된다.
     */
    private final List<Menu> menus;

    /**
     * 정적이고 보호되는 클래스 StoreHolder는,
     * 프로그램 전체에 유일하게 존재함이 보장되어야 하는 Store 인스턴스를 생성한다.
     */
    private static class StoreHolder {
        public static final Store INSTANCE = new Store();
    }

    /**
     * TodoNumber클래스는 주문/결제/종료를 선택하는 입력 구문에 대하여
     * 원시 타입을 감싸 예외처리를 용이하게 하는 클래스이다.
     */
    private static class TodoNumber {
        /**
         * number는 TodoNumber가 감싸고 있는 값, 즉 동작 선택에 대한 입력값이다.
         */
        private final int number;

        /**
         * 생성자 메서드는 파라미터를 받아 검사하고, 문제가 없다면 내부값으로 할당한다.
         *
         * @param number 입력을 통해 넘어온 정수값이다.
         */
        public TodoNumber(int number) {
            if (number < 1 || number > 3) {
                throw new IllegalArgumentException("잘못된 값입니다.");
            }
            this.number = number;
        }

        /**
         * isOrder는 만약 들어온 명령값이 주문이라면 true를, 아니면 false를 반환한다.
         *
         * @return 들어온 명령값이 주문인지 여부를 반환한다.
         */
        public boolean isOrder() {
            return number == 1;
        }

        /**
         * isPay는 만약 들어온 명령값이 결제라면 true를, 아니면 false를 반환한다.
         *
         * @return 들어온 명령값이 결제인지 여부를 반환한다.
         */
        public boolean isPay() {
            return number == 2;
        }

        /**
         * isEnd는 만약 들어온 명령값이 종료라면 true를, 아니면 false를 반환한다.
         *
         * @return 들어온 명령값이 종료인지 여부를 반환한다.
         */
        public boolean isEnd() {
            return number == 3;
        }
    }

    /**
     * 생성자 메서드이다.
     * 외부에서 호출되지 못하도록 보호된다.
     * 테이블 리스트와 메뉴 리스트를 생성해준다.
     */
    private Store() {
        tables = TableRepository.tables();
        menus = MenuRepository.menus();
    }

    /**
     * StoreHolder를 통해 유일성이 보장된 Store 객체를 반환한다.
     *
     * @return Store 객체를 반환한다.
     */
    public static Store getInstance() {
        return StoreHolder.INSTANCE;
    }

    /**
     * 주문, 결제, 종료 중 하나를 선택하는 입력값 todoNumber를 받는다.
     *
     * @return 입력된 todoNumber값을 반환한다.
     */
    private TodoNumber getTodoNumber() {
        TodoNumber todoNumber;
        OutputView.printTodoChoices();
        try {
            todoNumber = new TodoNumber(InputView.inputTodoNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값입니다. 값을 다시 입력해주세요");
            return getTodoNumber();
        }
        return todoNumber;
    }

    /**
     * getOrderTableNumber는 입력을 통해 주문할 테이블의 번호를 구하는 메서드이다.
     *
     * @return 주문할 테이블의 번호를 반환한다.
     * @throws IllegalArgumentException 만약 유효하지 않은 번호라면 예외처리 후 다시 입력을 받는다.
     */
    private int getOrderTableNumber() {
        int tableNumber;

        try {
            tableNumber = InputView.inputTableNumber();
            checkTableNumberException(tableNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값입니다. 값을 다시 입력해주세요");
            return getOrderTableNumber();
        }
        return tableNumber;
    }

    /**
     * checkTableNumberException은 입력받은 tableNumber에 대하여 예외처리할 부분이 있는지 검사한다.
     *
     * @param tableNumber 입력받은 테이블 번호 값이다. 정수형임이 보장된다.
     * @throws IllegalArgumentException 만약 테이블 번호에 맞는 테이블을 찾지 못하면 예외처리한다.
     */
    private void checkTableNumberException(int tableNumber) {
        for (Table table : tables) {
            if (table.isRightTableNumber(tableNumber)) {
                return;
            }
        }
        throw new IllegalArgumentException("확인할 수 없는 테이블입니다.");
    }

    /**
     * getMenuCode는 메뉴 코드(번호, 개수와 헷갈릴 수 있어 코드로 명명)를 입력받아 반환하는 메서드이다.
     * checkMenuCodeException을 통해 메뉴 코드에 문제가 있는지 검사한다.
     *
     * @return 입력받은 메뉴 코드를 반환한다.
     */
    private int getMenuCode() {
        int menuCode;

        try {
            menuCode = InputView.inputMenuCode();
            checkMenuCodeException(menuCode);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값입니다. 값을 다시 입력해주세요");
            return getMenuCode();
        }
        return menuCode;
    }

    /**
     * checkMenuCodeException은 메뉴 번호에 맞는 메뉴가 있는지 확인하고 없다면 예외처리하는 메서드이다.
     *
     * @param menuCode 입력된 메뉴 번호이다.
     * @throws IllegalArgumentException 없는 메뉴를 참조하였다면 예외처리를 한다.
     */
    private void checkMenuCodeException(int menuCode) {
        for (Menu menu : menus) {
            if (menu.isRightMenuNumber(menuCode)) {
                return;
            }
        }
        throw new IllegalArgumentException("확인할 수 없는 메뉴입니다.");
    }

    /**
     * sales는 매장을 운영하는 메서드이다.
     * 이 메서드가 호출되면, 매장이 문을 닫을때까지 영업을 진행한다.
     */
    public void sales() {
        TodoNumber todoNumber;
        while (true) {
            todoNumber = getTodoNumber();
            if (todoNumber.isOrder()) {
                order();
            }
            if (todoNumber.isPay()) {
                pay();
            }
            if (todoNumber.isEnd()) {
                break;
            }
        }
    }

    /**
     * order는 주문을 받는 일련의 동작을 수행하는 메서드이다.
     * 수행해야 할 로직은 다음과 같다.
     * 테이블 목록 출력, 테이블 선택,
     * 메뉴 목록 출력, 메뉴 선택, 메뉴 수량 입력,
     * 종료(테이블에 메뉴 가져다주기->글자 표시해주기)
     */
    private void order() {
        int tableNumber, menuCode, menuNumber;
        OutputView.printTables(tables);
        tableNumber = getOrderTableNumber();
        OutputView.printMenus(menus);
        menuCode = getMenuCode();
        //menuNumber = getMenuNumber();
    }

    /**
     * pay는 결제를 하는 일련의 동작을 수행하는 메서드이다.
     */
    private void pay() {

    }
}
