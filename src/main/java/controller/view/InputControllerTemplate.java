package controller.view;

import template.domain.ModelTemplate;
import template.view.InputView;
import template.view.OutputView;

public class InputControllerTemplate {
	public static ModelTemplate getModel() {
		try {
			return new ModelTemplate(InputView.templateInput());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getModel();
		}
	}

	// ...
}
