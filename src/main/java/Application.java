import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;
import domain.Register;

import java.util.List;

public class Application {
    private static final int REGISTER = 1;
    private static final int PAY = 2;
    private static final int EXIT_PROGRAM = 3;
    
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        
        OutputView.printMain();
        int order = InputView.inputOrder();
        
        while (order != EXIT_PROGRAM) {
        	 OutputView.printTables(tables);
        	if (order == REGISTER) {
            	Register.startOrder(tables, menus);
            } else if (order == PAY) {
            	
            }
        	OutputView.printMain();
        	order = InputView.inputOrder();
        }

    }
}
