package util;

import domain.Menu;
import domain.TableOrder;

public class ValidateUtil {
	private static final int MIN_ORDER_QUANTITY = 1;

	public static void validateMenuQuantity(int additionalQuantity, Menu menu, TableOrder tableOrder) {
		if (additionalQuantity < MIN_ORDER_QUANTITY) {
			throw new IllegalArgumentException("주문 수량 입력 오류");
		}
		if (!tableOrder.isAbleToOrderMenu(menu, additionalQuantity)) {
			throw new IllegalArgumentException("이미 최대치를 주문했어요.");
		}
	}

	public static void validateMenu(Menu menu, TableOrder tableOrder) {
	}
}
