import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		ChickenHouse pos = new ChickenHouse();
		pos.execute();
	}
}
