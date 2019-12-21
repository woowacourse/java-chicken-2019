import java.util.InputMismatchException;

import view.InputView;

public class MainCommand {
	private int value;
	private final String COMMAND_NAMES[] = {"주문등록", "결제하기", "프로그램 종료"};

	public MainCommand() {
		try {
			value = InputView.inputMainCommand();
			checkValid();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해 주세요.");
			InputView.flush();
			value = InputView.inputMainCommand();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			value = InputView.inputMainCommand();
		}
	}

	public boolean isOrder() {
		return value == 1;
	}

	public boolean isBill() {
		return value == 2;
	}

	public boolean isExit() {
		return value == 3;
	}

	private void checkValid() {
		if (value < 0 || value > COMMAND_NAMES.length) {
			throw new IllegalArgumentException(String.format("입력 명령은 1 ~ %d까지 가능합니다.", COMMAND_NAMES.length));
		}
	}
}
