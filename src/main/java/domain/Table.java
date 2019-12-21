package domain;

import domain.Menu;
import constant.ProjectConstant;

import java.util.ArrayList;

public class Table {
	private final int number;
	
	/**
	 * 테이블이 갖고 있는 메뉴와 수량의 짝
	 * @author giantim
	 *
	 */
	private class TableMenu {
		private Menu myMenu;
		private int menuCount;

		public TableMenu(Menu menu, int count) {
			myMenu = menu;
			menuCount = count;
		}

		public void printInformation() {
			System.out.println(myMenu.getName() + " " + Integer.toString(menuCount) + " "
					+ Integer.toString(myMenu.getPrice() * menuCount));
		}

		public int getMenuAllPrice() {
			return myMenu.getPrice() * menuCount;
		}

		public boolean isChicken() {
			return myMenu.getCategory().equals(ProjectConstant.CHICKEN);
		}

		public int discountMoney() {
			return (menuCount / 10) * 10000;
		}
	}

	private ArrayList<TableMenu> menuList;

	public Table(final int number) {
		this.number = number;
		this.menuList = new ArrayList<TableMenu>();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	public void addMenu(Menu menu, int menuCount) {
		menuList.add(new TableMenu(menu, menuCount));
	}

	public int getMenuListSize() {
		return this.menuList.size();
	}

	public void printMenu() {
		System.out.println("## 주문 내역");
		System.out.println("메뉴 수량 금액");
		for (TableMenu m : menuList) {
			m.printInformation();
		}
		System.out.println();
	}
	
	/**
	 * 모든 메뉴의 금액 합을 출력한다
	 * @return 모든 메뉴의 금액 합
	 */
	public double getAllMenuSum() {
		double sum = 0d;

		for (TableMenu m : menuList) {
			sum = sum + (double) m.getMenuAllPrice();
		}
		return discountForOverTen(sum);
	}
	
	/**
	 * 결제 수단이 현금인 경우 5프로 할인해준다
	 * @return 5프로 할인한 금액
	 */
	public double discountForCash() {
		return getAllMenuSum() * ProjectConstant.DISCOUNT;
	}

	/**
	 * 메뉴 중 치킨을 찾아 수량이 10 이상이면 10,000원 할인해준다
	 * @param pay 현재 금액
	 * @return 할인한 금액
	 */
	private double discountForOverTen(double pay) {
		double money = pay;

		for (TableMenu m : menuList) {
			if (m.isChicken()) {
				money = money - (double) m.discountMoney();
			}
		}
		return money;
	}

	public void clear() {
		this.menuList.clear();
	}
}
