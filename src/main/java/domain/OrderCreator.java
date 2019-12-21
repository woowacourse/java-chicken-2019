package domain;

import domain.model.Menu;
import domain.model.Order;
import domain.repository.MenuRepository;
import util.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 주방에 전달할 주문을 생성하는 역할의 클래스
 */
public class OrderCreator {
    private static final int ORDER_MIN_COUNT = 1;
    private List<Menu> menuList = MenuRepository.menus();

    private int inputMenuNumber() {
        String input = "";

        do {
            input = InputView.inputMenu();
        } while (!InputValidator.isNumber(input));

        return Integer.parseInt(input);
    }

    private int inputCount() {
        String input = "";

        do {
            input = InputView.inputCount();
        } while (!InputValidator.isNumberInRange(input, ORDER_MIN_COUNT, Integer.MAX_VALUE));

        return Integer.parseInt(input);
    }

    private Menu selectMenu() {
        OutputView.printMenus(menuList);
        int menuNumber = inputMenuNumber();

        while (!MenuRepository.isExist(menuNumber)) {
            OutputView.printNotExistMenu();
            menuNumber = inputMenuNumber();
        }

        return MenuRepository.search(menuNumber);
    }

    public Order makeOrder() {
        return new Order(selectMenu(), inputCount());
    }
}
