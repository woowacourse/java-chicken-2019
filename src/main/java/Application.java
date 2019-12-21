import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
	private final List<Table> tables = TableRepository.tables();
	private final List<Menu> menus = MenuRepository.menus();
	private int tableNumber;
	
	private void run() {
		InputView.showMainView();
	}
	
    public static void main(String[] args) {
    	Application app = new Application();
    	app.run();
    }
}
