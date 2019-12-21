package work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

import view.InputView;
import view.OutputView;

public class MainCommand {
	private int command;
	private final List<String> COMMAND_NAMES = Arrays.asList("1 - 주문등록", "2 - 결제하기", "3 - 프로그램 종료");
	public MainCommand(){
		OutputView.printMain(COMMAND_NAMES);
	}
	public int getCommand() {
		int value;
		try {
			value = InputView.inputMainCommand();
			Validation.checkPositiveRange(value, COMMAND_NAMES.size());
			this.command = value;
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
			InputView.flush();
			return getCommand();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getCommand();
		}
		return value;
	}

	public boolean isOrder() {
		return command == 1;
	}

	public boolean isBill() {
		return command == 2;
	}

	public boolean isExit() {
		return command == 3;
	}
}
