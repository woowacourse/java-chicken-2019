package utils;

import java.util.ArrayList;

public class Converter {
	public static int getInt(String moneyString) {
		return Integer.parseInt(moneyString);
	}

	public static String getString(int count) {
		return Integer.toString(count);
	}
}
