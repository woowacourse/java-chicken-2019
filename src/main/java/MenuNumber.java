import domain.Menu;
import domain.MenuRepository;

public class MenuNumber {
    private static final int MAX_NUMBER_OF_MENU = 99;

    private final int menuNumber;
    private final int numberOfMenu;

    public MenuNumber(int menuNumber, int numberOfMenu) {
        if (MenuRepository.isThereMenu(new Menu(menuNumber, null,
                null, 0))) {
            throw new IllegalArgumentException("입력한 메뉴가 메뉴 목록에 없습니다.");
        }
        if(numberOfMenu>MAX_NUMBER_OF_MENU){
            throw new IllegalArgumentException("메뉴는 최대 99회만 주문가능합니다.");
        }
        this.menuNumber = menuNumber;
        this.numberOfMenu = numberOfMenu;
    }
}