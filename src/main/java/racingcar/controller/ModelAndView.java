package racingcar.controller;

import java.util.HashMap;
import java.util.Map;

import racingcar.view.InputView;
import racingcar.view.ResultView;

class ModelAndView {
	private final Map<String, Object> modelMap = new HashMap<>();
	private final InputView inputView;
	private final ResultView resultView;

	ModelAndView(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	Object getParameter(String parameterName) {
		return modelMap.get(parameterName);
	}

	void putParameter(String parameterName, Object object) {
		modelMap.put(parameterName, object);
	}

	InputView getInputView() {
		return inputView;
	}

	ResultView getResultView() {
		return resultView;
	}
}
