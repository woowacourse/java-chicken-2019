/*
 * OneOrTwoOrThree.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

import java.util.Objects;

/**
 * 1,2,3을 의미하는 클래스입니다.
 *
 * @author HyungjuAn
 */
public class OneOrTwoOrThree {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;

	private final int value;

	public OneOrTwoOrThree(String value) {
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException("값이 null이 될 수 없습니다.");
		}
		if (value.length() > ONE) {
			throw new IllegalArgumentException("입력이 2 자 이상이 될 수 없습니다.");
		}
		this.value = Integer.parseInt(value);
		if (this.value < ONE || this.value > THREE) {
			throw new IllegalArgumentException("입력은 1 or 2 or 3이여야 합니다");
		}
	}

	public boolean isOne() {
		return value == ONE;
	}

	public boolean isTwo() {
		return value == TWO;
	}

	public boolean isThree() {
		return value == THREE;
	}
}
