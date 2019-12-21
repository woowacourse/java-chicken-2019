/*
 * InputUtil.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

/**
 * 인풋 유틸 클래스입니다.
 *
 * @author HyungjuAn
 */
public class InputUtil {
	public static OneOrTwoOrThree checkMainMenuNumber(String mainMenuInput) {
		return new OneOrTwoOrThree(mainMenuInput);
	}

	public static TableNumber checkTableNumber(String tableNumberInput) {
		return new TableNumber(tableNumberInput);
	}

	public static MenuNumber checkMenuNumber(String menuNumberInput) {
		return new MenuNumber(menuNumberInput);
	}

	public static MenuCount checkMenuCount(String menuCountInput) {
		return new MenuCount(menuCountInput);
	}
}
