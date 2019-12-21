package work;

public class Validation {
	private static final String RANGE_FORMAT="%d ~ %d 까지의 수만 가능합니다.";

	public static void checkPositiveRange(int target, int limit){
		if (target < 0 || target > limit ) {
			throw new IllegalArgumentException(String.format(RANGE_FORMAT,1, limit));
		}
	}
}
