package domain.menu;

import java.util.List;

/**
 * Order 클래스는 주문 목록을 저장하는 클래스이다.
 * 내부 클래스 MenuWithNumber를 통해 메뉴와 그 개수를 저장하고,
 * MenuWithNumber List를 통해 주문받은 메뉴들을 저장한다.
 */
public class Order {
    /**
     * MenuWithNumber는 메뉴와 그 갯수를 묶은 콜렉션이다.
     * 생성자 호출 이후에는 메뉴를 재할당할 수 없지만, 개수는 추가(삭제는 로직상 필요없음)할 수 있다.
     * 메뉴 추가와 메뉴 검사 등의 메서드를 가지고 있다.
     */
    private class MenuWithNumber{
        /**
         * menu는 이 객체를 통해 관리할 메뉴 객체이다. 재할당이 불가하다.
         */
        private final Menu menu;
        /**
         * number는 메뉴의 개수를 저장한 정수형 변수이다. 재할당이 가능하다.
         */
        private int number;

        /**
         * 생성자를 호출하면 메뉴와 넘버를 할당해준다.
         * @param menu 입력된 메뉴
         * @param number 입력된 개수
         */
        public MenuWithNumber(Menu menu, int number){
            this.menu = menu;
            this.number = number;
        }

        /**
         * addMenuNumber는 메뉴와 숫자를 받아, 만약 이 객체의 메뉴가 맞다면
         * 숫자만큼 개수를 늘려주는(더 주문하는) 메서드이다.
         *
         * @param menu 확인할 메뉴 객체이다.
         * @param number 추가할 개수를 전달하는 정수형 변수이다.
         */
        public void addMenuNumber(Menu menu, int number){
            if(isSameMenu(menu)) {
                this.number += number;
            }
        }

        /**
         * isSameMenu는 메뉴 객체를 입력받아 이 객체가 가진 메뉴 객체와 비교하여 결과를 반환한다.
         *
         * @param menu 검사할 메뉴 객체
         * @return 같으면 true를, 아니라면 false를 반환한다.
         */
        public boolean isSameMenu(Menu menu){
            return this.menu == menu;
        }
    }

    /**
     * orderList는 MenuWithNumber를 통해 저장된 메뉴-개수들의 목록이다.
     * 이를 통해 어떤 메뉴는 몇 개 시켰는지 확인이 가능하다.
     */
    private List<MenuWithNumber> orderList;

    /**
     * 생성자 호출 시 메뉴의 목록(Store에서 만든 메뉴 목록)을 받는다.
     * 이 목록에 맞춰서 orderList를 만드는데, 단 모두 개수를 0으로 설정하여 주문되지 않은 메뉴에 대해서는 0개로 표시한다.
     *
     * @param menus 새로 만들 주문리스트에서 사용할 총 메뉴의 목록
     */
    public Order(List<Menu> menus){
        for(Menu menu : menus) {
            orderList.add(new MenuWithNumber(menu,0));
        }
    }

    /**
     * orderMenu는 어떤 메뉴를 주문하는 동작을 수행하는 메서드이다.
     * 입력받은 메뉴를 orderList에서 검색하여, 조회가 되면 숫자를 추가해준다.
     *
     * @param menu 주문할 메뉴의 정보를 담은 객체
     * @param number 주문할 갯수
     */
    public void orderMenu(Menu menu, int number){
        for(MenuWithNumber order : orderList) {
            order.addMenuNumber(menu, number);
        }
    }
}
