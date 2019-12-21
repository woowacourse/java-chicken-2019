package work;

import java.util.List;

public class Validation {
	private static final String RANGE_FORMAT="%d ~ %d 까지의 수만 가능합니다.";

	public static void checkPositiveRange(int target, int limit){
		if (target < 1 || target > limit ) {
			throw new IllegalArgumentException(String.format(RANGE_FORMAT,1, limit));
		}
	}

	public static void checkInList(int value, List<Integer> collect) {
		if(!collect.contains(value)){
			throw new IllegalArgumentException("유효하지 않은 입력입니다.");
		}
	}
}
