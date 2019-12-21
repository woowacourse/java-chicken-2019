import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        int command; //명령어
        int tableNumber; //테이블 번호
        int menuType; //주문하고자 하는 메뉴의 번호
        int numberOfMenu; //주문할 메뉴의 수량
        int tableIndex; //tables에 들어있는 table의 index
        int methodOfPayment; // 결제 수단
         do{
        	 OutputView.printCommandList();
        	 command = InputView.inputCommandList();
        	if(command==1) {
        		// 주문등록
        		OutputView.printTables(tables);
        		tableNumber = InputView.inputTableNumber();
        		tableIndex = parseTableNumberToIndex(tableNumber,tables);
        		OutputView.printMenus(menus);
        		menuType = InputView.inputMenuType();
        		numberOfMenu = InputView.inputMenuNumber();
        		tables.get(tableIndex).order(menuType, numberOfMenu);
        	}
        	if(command==2) {
        		// 결제하기
        		OutputView.printTables(tables);
        		tableNumber = InputView.inputTableNumber();
        		tableIndex = parseTableNumberToIndex(tableNumber,tables);
        		OutputView.printReceipt(tables.get(tableIndex));
        		methodOfPayment = InputView.inputMethodOfPayment(tableNumber);
        		OutputView.printTotalPrice(tables.get(tableIndex), methodOfPayment);
        		tables.get(tableIndex).clearOder();
        	}
        }while(command!=3);
        
    }
    
    public static int parseTableNumberToIndex(int tableNumber, List<Table> tables) {
    	int index = 0;
    	for(int i=0;i<tables.size();i++) {
    		if(tables.get(i).getNumber()==tableNumber) {
    			index = i;
    		}
    	}
    	return index;
    }
}
