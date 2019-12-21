package domain;

import domain.TableRepository;
import domain.Table;
import domain.Menu;
import domain.MenuRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Payment {
	public static void startPayment(List<Table> tables, List<Menu> menus) {
		if (tables.stream()
				.map(Table::isOrderedTable)
				.filter(num -> num != -1)
				.collect(Collectors.toList()).size() < 1) {
			System.out.println("결제를 진행할 테이블이 없습니다.");
			return;
		}
		
	}
}
