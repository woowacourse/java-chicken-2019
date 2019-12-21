import java.io.IOException;
import java.util.List;

import controller.ChickenController;
import domain.Table;
import domain.TableRepository;

public class Application {
    private static final String PROGRAM_ERROR = "프로그램에 문제가 있는 것 같습니다. 담당자에게 문의 주세요(010-3002-5691)";

    // TODO 구현 진행
    public static void main(String[] args) throws IOException {
        try {
            final List<Table> tables = TableRepository.tables();
            ChickenController.playPos(tables);
        } catch (Exception e) {
            System.out.println(PROGRAM_ERROR);
            e.printStackTrace();
        }

    }
}
