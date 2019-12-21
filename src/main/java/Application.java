import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OutputView.printFunctions();

        final int functionNumber = getInputFunctionNumber();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private static int getInputFunctionNumber() {
        try {
            final int functionNumber = InputView.inputFunctionNumber();
            return isValid(functionNumber);
        } catch (InputMismatchException e) {
            System.out.println("1부터 3까지의 숫자만 입력 가능합니다.");
            return getInputFunctionNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputFunctionNumber();
        }
    }

    private static int isValid(int functionNumber) {
        if (functionNumber > 3 || functionNumber < 1) {
            throw new IllegalArgumentException("입력한 기능 목록이 존재하지 않습니다. 1부터 3까지의 숫자만 입력 가능합니다.");
        }
        return functionNumber;
    }
}
