/*
 * MenuCount.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

import java.util.Objects;

/**
 * 메뉴 수를 나타내는 클래스입니다.
 *
 * @author HyungjuAn
 */
public class MenuCount {
	private static final int MAXIMUM_COUNT = 99;
	private static final int MINIMUM_COUNT = 1;

	private final int value;

	public MenuCount(String value) {
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException("값이 null이 될 수 없습니다.");
		}
		this.value = Integer.parseInt(value);
		if (this.value < MINIMUM_COUNT || this.value > MAXIMUM_COUNT) {
			throw new IllegalArgumentException("입력이 1미만 99초과 일 수 없습니다.");
		}
	}

	public int getValue() {
		return value;
	}
}
