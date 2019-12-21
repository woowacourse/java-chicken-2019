import java.io.IOException;
import java.util.List;

import controller.ChickenController;
import domain.Table;
import domain.TableRepository;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) throws IOException {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        ChickenController.playPos();
    }
}
