/*
 * TotalOrder.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

import java.util.HashMap;
import java.util.List;

import domain.Menu;

/**
 * 총 주문 내역 클래스입니다.
 *
 * @author HyungjuAn
 */
public class TotalOrder {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final String TOTAL_ORDER = "메뉴 수량 금액\n";
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	private HashMap<Menu, Integer> totalMenus;

	public TotalOrder(List<Menu> menus) {
		totalMenus = new HashMap<>();

		for (Menu menu : menus) {
			if (totalMenus.containsKey(menu)) {
				totalMenus.put(menu, totalMenus.get(menu) + ONE);
				continue;
			}
			totalMenus.put(menu, ONE);
		}
	}

	public int getTotalPay() {
		int totalPay = 0;

		for (Menu menu : totalMenus.keySet()) {
			int menuCount = totalMenus.get(menu);
			totalPay += menu.getPrice() * menuCount;
		}
		return totalPay;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(TOTAL_ORDER);
		for (Menu menu : totalMenus.keySet()) {
			int menuCount = totalMenus.get(menu);

			builder.append(menu.getName()).append(SPACE)
				.append(menuCount).append(SPACE)
				.append(menuCount * menu.getPrice()).append(NEW_LINE);
		}
		return builder.toString();
	}
}
