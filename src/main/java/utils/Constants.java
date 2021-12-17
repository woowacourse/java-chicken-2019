package utils;

import java.util.Arrays;
import java.util.regex.Pattern;

import domain.Menu;
import domain.repository.MenuRepository;
import domain.repository.TableRepository;

public class Constants {
	// 단위 상수
	public static final String CONSTANT = "상수";

	// 정규식
	// 사이트: https://regexr.com/5mhou
	public static final Pattern PATTERN_MAIN_NUM = Pattern.compile("^[123]$");
	public static final Pattern PATTERN_COUNT_NUM = Pattern.compile("^[1-9][0-9]?$");

	// 오류메세지 관련 상수
	public static final String ERROR_NUMBER_PATTERN = "숫자 입력은 비지 않은 1 이상의 정수 형식이어야 한다.";
	public static final String ERROR_MAIN_NUMBER_PATTERN = "123 중 하나를 입력해야 한다.";
	public static final String ERROR_TABLE_NUMBER_PATTERN =
		Arrays.toString(TableRepository.TABLE_NUMS) + " 중 하나를 입력해야 한다.";
	public static final String ERROR_MENU_NUMBER_PATTERN =
		Arrays.toString(MenuRepository.MENU_NUMS) + " 중 하나를 입력해야 한다.";
	public static final String ERROR_MENU_COUNT_PATTERN = "한 메뉴 당 99개 이상 주문할 수 없다.";
}
