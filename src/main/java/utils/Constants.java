package utils;

import java.util.regex.Pattern;

public class Constants {
	// 단위 상수
	public static final String CONSTANT = "상수";

	// 정규식
	// 사이트: https://regexr.com/5mhou
	public static final String REGEX = "^[가-힣a-zA-Z]+$";
	public static final Pattern PATTERN = Pattern.compile(REGEX);

	// 오류메세지 관련 상수
	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_NUMBER_PATTERN = ERROR + "숫자 입력은 비지 않은 1 이상의 정수 형식이어야 한다.";
}
