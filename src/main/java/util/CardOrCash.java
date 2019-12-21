/*
 * CardOrCash.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

import java.util.Objects;

/**
 * 지불방법을 나타내는 클래스입니다.
 *
 * @author HyungjuAn
 */
public class CardOrCash {
	private static final int CARD = 1;
	private static final int CASH = 2;
	private static final int TWO = 2;

	private final int value;

	public CardOrCash(String value) {
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException("값이 null이 될 수 없습니다.");
		}
		if (value.length() > TWO) {
			throw new IllegalArgumentException("입력이 2 자 이상이 될 수 없습니다.");
		}
		this.value = Integer.parseInt(value);
		if (this.value < CARD || this.value > CASH) {
			throw new IllegalArgumentException("입력은 1 or 2이여야 합니다");
		}
	}

	public int getValue() {
		return value;
	}

	public boolean isCard() {
		return value == CARD;
	}

	public boolean isCash() {
		return value == CASH;
	}
}
