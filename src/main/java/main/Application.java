package main;

import domain.store.Store;

/**
 * Application 클래스는 main 메서드를 포함하는 객체이다.
 */
public class Application {
    /**
     * main 메서드는 프로그램이 시작될 때 호출되는 메서드이다.
     * Store 객체를 전달받아, 매장을 운영하고 매장 운영이 종료되면 같이 종료된다.
     * @param args 기본 파라미터
     */
    public static void main(String[] args) {
        final Store store = Store.getInstance();

        store.sales();
    }
}
