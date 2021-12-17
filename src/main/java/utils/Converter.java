package utils;

import java.util.ArrayList;

public class Converter {
	public static int getInt(String moneyString) {
		return Integer.parseInt(moneyString);
	}

	public static String getString(int count) {
		return Integer.toString(count);
	}

	// spilt 코드
	// public static ArrayList<Beverage> getBeverages(String beverageString) {
	// 	ArrayList<Beverage> beverages = new ArrayList<>();
	// 	for (String beverage : beverageString.split(Constants.SEPARATOR)) {
	// 		beverages.add(new Beverage(
	// 			beverage
	// 				.substring(1, beverage.length() - 1)
	// 				.split(Constants.DELIMITER)));
	// 	}
	// 	return beverages;
	// }
}
