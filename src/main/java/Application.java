import domain.*;
import view.InputView;

import javax.naming.SizeLimitExceededException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SizeLimitExceededException {
        final List<Table> tables = TableRepository.tables();
        //final int tableNumber = InputView.inputTableNumber();
        final List<Menu> menus = MenuRepository.menus();

        while (true) {
            int inputFeature = InputView.inputFeature();
            if (inputFeature == 1)
                AddOrderRoutine.addOrderRoutine(tables, menus);

            if (inputFeature == 2)
                CheckoutRoutine.checkoutRoutine(tables);

            if (inputFeature == 3)
                System.exit(0);
        }
    }


}
