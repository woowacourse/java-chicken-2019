import domain.Menu;
import domain.MenuRepository;

public class MenuNumber {
    private static final int MAX_NUMBER_OF_MENU = 99;

    private int menuNumber;
    private int numberOfMenu;
    private Menu menu;

    public MenuNumber(int menuNumber, int numberOfMenu) {
        if ((menu = MenuRepository.getMenuByNumber(menuNumber)) == null) {
            throw new IllegalArgumentException("입력한 메뉴가 메뉴 목록에 없습니다.");
        }
        if(numberOfMenu>MAX_NUMBER_OF_MENU){
            throw new IllegalArgumentException("메뉴는 최대 99회만 주문가능합니다.");
        }
        this.menuNumber = menuNumber;
        this.numberOfMenu = numberOfMenu;
    }

    public Menu getMenu(){
        return menu;
    }
    public int getNumberOfMenu(){
        return numberOfMenu;
    }
}