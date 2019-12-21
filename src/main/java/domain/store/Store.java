package domain.store;

/**
 * Store 클래스는 매장 전반의 운영을 담당하는 클래스이다.
 * 메뉴와 테이블을 포함하여 이들을 관리/운영하고,
 * 결제 객체를 통해 결제를 진행한다.
 * 입력에 따라 프로그램이 종료되면, 매장의 운영을 종료한다.
 */
public class Store {
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
     */
    private Store() {

    }

    /**
     * StoreHolder를 통해 유일성이 보장된 Store 객체를 반환한다.
     *
     * @return Store 객체를 반환한다.
     */
    public static Store getInstance() {
        return StoreHolder.INSTANCE;
    }
}
