import domain.Table;
import domain.TableRepository;
import service.*;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Service> services = new ArrayList<Service>();
        services.add(new OrderRegistor());
        services.add(new Biller());
        services.add(new ProgramFinisher());

        final ServiceSelector serviceSelector = new ServiceSelector(services);
        final List<Table> tables = TableRepository.tables();

        while(true) {
            Service selectedService = serviceSelector.selectService(InputView.inputServiceNumber());
            selectedService.run(tables);
        }
    }
}
