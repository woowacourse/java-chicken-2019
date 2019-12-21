/*
 * TableNumber.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

import java.util.List;
import java.util.Objects;

import domain.Table;
import domain.TableRepository;

/**
 * 테이블 번호 클래스입니다.
 *
 * @author HyungjuAn
 */
public class TableNumber {
	private static final int ORDER_SWITCH = 1;
	private static final int PAY_SWITCH = 2;
	private static final int LENGTH_LIMIT = 1;
	private final List<Table> tables = TableRepository.tables();
	private final int value;

	public TableNumber(String value, int mainMenuNumber) {
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException("값이 null이 될 수 없습니다.");
		}
		if (value.length() > LENGTH_LIMIT) {
			throw new IllegalArgumentException("입력이 2 자 이상이 될 수 없습니다.");
		}
		this.value = Integer.parseInt(value);
		if (!tables.stream().anyMatch(table -> table.getNumber() == this.value)) {
			throw new IllegalArgumentException("존재하지 않는 테이블입니다.");
		}
		functionSwitch(mainMenuNumber);
	}

	private void functionSwitch(int mainMenuNumber) {
		if (mainMenuNumber == ORDER_SWITCH) {
			tables.stream().filter(table -> table.getNumber() == this.value).forEach(table -> {
				if (table.isUse()) {
					throw new IllegalArgumentException("이미 사용중인 테이블입니다.");
				}
			});
		}
		if (mainMenuNumber == PAY_SWITCH) {
			tables.stream().filter(table -> table.getNumber() == this.value).forEach(table -> {
				if (!table.isUse()) {
					throw new IllegalArgumentException("사용중이 아닌 테이블입니다.");
				}
			});
		}
	}

	public int getValue() {
		return value;
	}
}
