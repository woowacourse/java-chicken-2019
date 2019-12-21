import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printMainFeatures();
        MainFeatureNumber mainFeatureNumber = InputView.inputMainFeatureNumber();
        if (mainFeatureNumber.isExit()) {
            System.out.println("포스 프로그램이 종료되었습니다.");
            return;
        }
        if (mainFeatureNumber.isOrder()) {
            OutputView.printTables(tables);
        }
        if (mainFeatureNumber.isPay()) {
            OutputView.printTables(tables);
        }
    }
}
