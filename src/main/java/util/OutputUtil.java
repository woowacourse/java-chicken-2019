/*
 * OutputUtil.java                        1.0.0   2019-12-21
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package util;

import java.util.List;

import domain.Menu;

/**
 * 아웃풋 유틸 클래스입니다.
 *
 * @author HyungjuAn
 */
public class OutputUtil {
	public static TotalOrder getOrderedList(List<Menu> orderedMenus) {
		return new TotalOrder(orderedMenus);
	}
}
