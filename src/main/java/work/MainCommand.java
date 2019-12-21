package work;

import java.util.InputMismatchException;

import view.InputView;

public class MainCommand {
	private int command;
	private final String COMMAND_NAMES[] = {"주문등록", "결제하기", "프로그램 종료"};

	public int getCommand(){
		int value;
		try{
			value=InputView.inputMainCommand();
			Validation.checkPositiveRange(value,COMMAND_NAMES.length);
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
}
