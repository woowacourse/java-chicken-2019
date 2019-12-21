import domain.*;
import view.InputView;
import view.OutputView;


import java.util.List;

public class Application {
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        while (true) {
            int programIndex = getProgramIndex();
            if (programIndex == 3 && checkFinish())
                break;
            orderOrPay(programIndex);
        }
        checkEveryTablePayment();
        System.out.println("프로그램을 종료합니다.");
    }

    public static void orderOrPay(int programIndex) {
        if (programIndex == 3)
            return;

        int tableIndex = getTableNumber();
        if (programIndex == 1) {
            Order order = new Order(TableRepository.getTable(tableIndex));
            order.getOrder();
        }
        if (programIndex == 2) {
            Payment payment = new Payment(TableRepository.getTable(tableIndex));
            payment.pay();
        }
    }

    public static boolean checkFinish() {
        checkEveryTablePayment();
        String input;
        do {
            input = InputView.inputFinishSign();
        } while(!Validate.validateYesOrNo(input));

        char yesOrNo = Character.toLowerCase(input.charAt(0));
        if(yesOrNo == 'y')
            return true;
        return false;
    }

    public static int getProgramIndex() {
        OutputView.printProgramCategory();
        System.out.println();
        String inputProgramCategory = InputView.inputProgramCategory();
        int index = ProgramCategory.getProgramIndex(inputProgramCategory);
        if (index == -1) {
            System.out.println();
            return getProgramIndex();
        }
        return index;
    }

    public static int getTableNumber() {
        OutputView.printTables(getTables());
        final String tableInput = InputView.inputTableNumber();
        if (TableRepository.validateTableInput(tableInput)) {
            return Integer.parseInt(tableInput);
        }
        return getTableNumber();
    }

    public static List<Table> getTables() {
        return tables;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public static void checkEveryTablePayment() {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getTotalMenuCount() > 0) {
                System.out.println("아직 결제하지 않은 테이블이 있습니다.");
                return;
            }
        }
    }
}
