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
    private final List<Table> tables;

    private final List<Menu> menus;

    /**
     * 정적이고 보호되는 클래스 StoreHolder는,
     * 프로그램 전체에 유일하게 존재함이 보장되어야 하는 Store 인스턴스를 생성한다.
     */
    private static class StoreHolder {
        public static final Store INSTANCE = new Store();
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
     * @return 입력된 todoNumber값을 반환한다.
     */
    private int getTodoNumber() {
        final int todoNumber;
        try{
            todoNumber = InputView.inputTodoNumber();
            checkTodoNumberException(todoNumber);
        } catch (InputMismatchException e){
            System.out.println("잘못된 값입니다. 값을 다시 입력해주세요");
            return getTodoNumber();
        }
        return todoNumber;
    }

    /**
     * 입력된 todoNumber값에 대하여, 예외처리할 사항을 검사한다.
     * @param todoNumber 입력된 숫자 todoNumber이다.
     * @throws InputMismatchException 만약 입력값이 정해진 범위보다 크거나 작으면 예외처리시킨다.
     */
    private void checkTodoNumberException(int todoNumber){
        if(todoNumber < 1 || todoNumber > 3){
            throw new InputMismatchException("입력은 1,2,3만 가능합니다.");
        }
    }

    /**
     * sales는 매장을 운영하는 메서드이다.
     * 이 메서드가 호출되면, 매장이 문을 닫을때까지 영업을 진행한다.
     */
    public void sales() {
        int todoNumber;
        while (true) {
            todoNumber = getTodoNumber();
            if(todoNumber == 1){
                //주문 로직
            }
            if(todoNumber == 2){
                //결제 로직
            }
            break;
        }
    }
}
