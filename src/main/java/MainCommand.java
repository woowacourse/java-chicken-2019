import java.util.InputMismatchException;

import view.InputView;

public class MainCommand {
	private int command;
	private final String COMMAND_NAMES[] = {"주문등록", "결제하기", "프로그램 종료"};

	public int getCommand(){
		int value;
		try{
			value=InputView.inputMainCommand();
			checkValid(value);
			this.command =value;
		}catch(InputMismatchException e){
			System.out.println("숫자를 입력해주세요.");
			InputView.flush();
			return getCommand();
		}catch(Exception e){
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

	private void checkValid(int value) {
		if (value < 0 || value > COMMAND_NAMES.length) {
			throw new IllegalArgumentException(String.format("입력 명령은 1 ~ %d까지 가능합니다.", COMMAND_NAMES.length));
		}
	}
}
