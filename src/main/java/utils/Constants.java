package utils;

import java.util.Arrays;
import java.util.regex.Pattern;

import domain.repository.MenuRepository;
import domain.repository.TableRepository;

public class Constants {
	// 정규식
	public static final Pattern PATTERN_MAIN_NUM = Pattern.compile("^[123]$");
	public static final Pattern PATTERN_COUNT_NUM = Pattern.compile("^[1-9][0-9]?$");
	public static final Pattern PATTERN_PAY_NUM = Pattern.compile("^[12]$");

	// 오류메세지 관련 상수
	public static final String ERROR_MAIN_NUMBER_PATTERN = "숫자 1,2,3 중 하나를 입력해야 한다.";
	public static final String ERROR_TABLE_NUMBER_PATTERN = "숫자"
		+ Arrays.toString(TableRepository.TABLE_NUMS) + " 중 하나를 입력해야 한다.";
	public static final String ERROR_MENU_NUMBER_PATTERN =
		Arrays.toString(MenuRepository.MENU_NUMS) + " 중 하나를 입력해야 한다.";
	public static final String ERROR_MENU_COUNT_PATTERN = "한 메뉴 당 99개 이상 주문할 수 없다.";
	public static final String TABLE_IS_NOT_IN = "유저가 없는 테이블을 선택했다.";
	public static final String ERROR_PAY_NUMBER_PATTERN = "숫자 1,2 중 하나를 입력해야 한다.";

	public static final int DIVIDER = 10;
	public static final int DISCOUNT_MONEY_UNIT = 10000;
	public static final int PAY_CARD = 1;
	public static final int PAY_CASH = 2;
	public static final String ERROR_NO_USER = "결제 가능한 테이블이 없다.";
}
