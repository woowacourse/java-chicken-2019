import domain.FunctionCaller;
import domain.Menu;
import domain.MenuRepository;
import domain.ProvidingFunction;
import domain.ProvidingFunctionRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        int functionNumber;

        final List<ProvidingFunction> providingFunctions
                = ProvidingFunctionRepository.providingFunctions();

        OutputView.printProvidingFunctions(providingFunctions);
        functionNumber = InputView.inputProvidingFunctionNumber();

        while (!ProvidingFunctionRepository.isExit(functionNumber)) {
            FunctionCaller.callFunction(functionNumber);

            OutputView.printProvidingFunctions(providingFunctions);
            functionNumber = InputView.inputProvidingFunctionNumber();
        }
    }
}
