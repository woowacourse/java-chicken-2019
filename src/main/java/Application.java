import Constant.ConstantNumber;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();
    public static void main(String[] args) {
        while(true){
            int Action = InputView.inputAction();
            if(Action == ConstantNumber.EXIT){
                break;
            }else if(Action == ConstantNumber.ORDER){
                order();
            }else if(Action == ConstantNumber.PAY){
                pay();
            }
        }
    }

    public static void order(){
        int tableNumber, menuNumber;

        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        if(tableNumber == ConstantNumber.CANNOT_ORDER){
            return;
        }
        OutputView.printMenus(menus);
        Menu menu = MenuRepository.getMenuByNumber(InputView.inputMenu());
        menuNumber = InputView.inputOrderNumber();

        TableRepository.getTablebyNumber(tableNumber).addOrder(menu, menuNumber);
    }

    public static void pay(){
        int tableNumber, howToPay;
        OutputView.printTables(tables);
        if(!TableRepository.hasTableToPay()){
            return;
        }
        tableNumber = InputView.inputTableNumber_Pay();
        OutputView.printOrders(TableRepository.getTablebyNumber(tableNumber));
        howToPay = InputView.inputHowToPay();
        System.out.println("## 최종 결제할 금액");
        System.out.println(discountCalculator(TableRepository.getTablebyNumber(tableNumber), howToPay));
        System.out.println();
    }

    private static int discountCalculator(Table table, int Card_or_Cash){
        double price = table.getTotalPrice();
        price -= table.getTotalChicken() / ConstantNumber.TEN * ConstantNumber.TEN_THOUSAND;
        if(Card_or_Cash == ConstantNumber.CASH){
            price *= ConstantNumber.FIVE_PERSENT_DISCOUNT;
        }

        return (int)price;
    }
}
