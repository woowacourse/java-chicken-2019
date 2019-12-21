package domain;

import domain.Menu;

import java.util.ArrayList;

import constant.ProjectConstant;

public class Table {
	private final int number;

	private class TableMenu {
		private Menu myMenu;
		private int menuCount;

		public TableMenu(Menu menu, int count) {
			myMenu = menu;
			menuCount = count;
		}

		public void printInformation() {
			System.out.println(
					myMenu.getName() + " " + Integer.toString(menuCount) + " " 
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
	
	public double getAllMenuSum() {
		double sum = 0d;
		
		for (TableMenu m : menuList) {
			sum = sum + (double)m.getMenuAllPrice();
		}
		return discountForOverTen(sum);
	}
	
	public double discountForCash() {
		return getAllMenuSum() * ProjectConstant.DISCOUNT;
	}
	
	private double discountForOverTen(double pay) {
		double money = pay;
		
		for (TableMenu m : menuList) {
			if (m.isChicken()) {
				money = money - (double)m.discountMoney(); 
			}
		}
		return money;
	}
	
	public void clear() {
		this.menuList.clear();
	}
}
