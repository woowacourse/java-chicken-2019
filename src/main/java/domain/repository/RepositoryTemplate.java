package domain.repository;

import utils.Constants;

public class RepositoryTemplate {
	public static final Object model = null;
	public static final Object[] models = null;

	public static Object get() {
		return model;
	}

	public static Object find(String name) {
		for (Object obj : models) {
			if (obj.equals(name)) {
				return obj;
			}
		}
		// 결과가 없으면 예외처리
		throw new IllegalArgumentException(Constants.ERROR);
	}
}
