/*
 * MenuNumber.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

import java.util.List;
import java.util.Objects;

import domain.Menu;
import domain.MenuRepository;

/**
 * 메뉴 번호 클래스입니다.
 *
 * @author HyungjuAn
 */
public class MenuNumber {
	private final List<Menu> menus = MenuRepository.menus();
	private final int value;

	public MenuNumber(String value) {
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException("값이 null이 될 수 없습니다.");
		}
		if (value.length() > 1) {
			throw new IllegalArgumentException("입력이 2 자 이상이 될 수 없습니다.");
		}
		this.value = Integer.parseInt(value);
		if (!menus.stream().anyMatch(menu -> menu.getNumber() == this.value)) {
			throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
		}
	}

	public int getValue() {
		return value;
	}
}
