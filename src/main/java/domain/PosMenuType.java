package domain;

import java.util.stream.Stream;

/**
 * 포스에서 선택할 수 있는 메인화면 항목 열거형
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public enum PosMenuType {
	ADD_ORDER("1"),
	PAYMENT("2"),
	END_PROGRAM("3"),
	START("4");

	private String text;

	PosMenuType(String text) {
		this.text = text;
	}

	public static PosMenuType of(String input) {
		return Stream.of(PosMenuType.values())
				.filter(menu -> menu.text.equals(input))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 선택입니다."));
	}
}
