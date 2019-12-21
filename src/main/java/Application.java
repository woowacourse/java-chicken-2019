import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import service.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IllegalAccessException {
        List<Service> services = new ArrayList<Service>();
        services.add(new OrderRegistor(1,"주문등록"));
        services.add(new Biller(2,"결제하기"));
        services.add(new ProgramFinisher(3,"프로그램 종료"));
        OutputView.printServices(services);

        Service selectedService = new ServiceSelector(services).selectService(InputView.inputServiceNumber());

        final List<Table> tables = TableRepository.tables();
        boolean continuePrograme = true;

        while(continuePrograme) {
            continuePrograme = selectedService.run(tables);
        }
    }
}
