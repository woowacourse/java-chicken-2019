package services;

import domain.MenuRepository;
import domain.TableRepository;
import exceptions.OutOfNumberException;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {
	final static int INITIAL_VALUE = 0;
	private static Scanner scanner = new Scanner(System.in);

	public static Integer handleExceptionOfMenuNumber() {
		Integer input = INITIAL_VALUE;

		OutputView.printMenus(MenuRepository.menus());
		try {
			input = scanner.nextInt();
			MenuRepository.isIntInMenus(input);
		} catch (OutOfNumberException e) {
			System.out.println("없는 메뉴입니다\n");
		}// catch (InputMismatchException e) {
		//System.out.println("숫자만 입력 가능합니다\n");
        //}
		return input;
	}

	public static Integer handleExceptionOfTableNumber() {
		Integer input = INITIAL_VALUE;

		OutputView.printTables(TableRepository.tables());
		try {
			input = scanner.nextInt();
			TableRepository.isIntInTables(input);
		} catch (OutOfNumberException e) {
			System.out.println("없는 테이블입니다\n");
		}// catch (InputMismatchException e) {
         //   System.out.println("숫자만 입력 가능합니다\n");
		//} 버그 수정 필
		return input;
	}

	public static Integer handleExceptionOfMenuQuantity() {
		final Integer MAX_QUANTITY = 99;

		Integer input = INITIAL_VALUE;
		try {
			input = scanner.nextInt();
			if (input > MAX_QUANTITY) {
				throw new OutOfNumberException();
			}
		} catch (OutOfNumberException e) {
			System.out.println("99개 이하로만 주문 가능합니다\n");
		}// catch (InputMismatchException e) {
         //   System.out.println("숫자만 입력 가능합니다\n");
        //}
            return input;
	}

	public static Integer handExceptionOfMainFeature() {
		final Integer MIN_FEATURE = 1;
		final Integer MAX_FEATURE = 3;
		final Integer INPUT_ERROR = 0;

		Integer input = INITIAL_VALUE;
		try {
			input = scanner.nextInt();
			if (input < MIN_FEATURE || input > MAX_FEATURE) {
				throw new OutOfNumberException();
			}
		} catch (OutOfNumberException e) {
			System.out.println("메뉴는 1-3번만 입력가능합니다\n");
		}// catch (InputMismatchException e) {
		 //  System.out.println("숫자만 입력 가능합니다\n");
        //}
		return input;
	}
}
