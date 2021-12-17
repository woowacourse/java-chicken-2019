package domain;

import template.utils.validator.TemplateValidator;

public class ModelTemplate {
	private int model;

	public ModelTemplate(String model) {
		new TemplateValidator(model);
		// 컨버터 이용해 값 적절하게 변경
	}

	public int get() {
		return model;
	}

	public boolean isEmpty() {
		return model == 0;
	}

	public boolean equals(ModelTemplate obj) {
		// 모델값 같은지 확인
		return this.model == obj.get();
	}

	@Override
	public String toString() {
		// 프린트 원하는 방식으로 구현
		return Integer.toString(model);
	}
}
