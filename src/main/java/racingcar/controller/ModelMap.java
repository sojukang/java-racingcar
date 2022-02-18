package racingcar.controller;

import java.util.HashMap;
import java.util.Map;

class ModelMap {
	private final Map<String, Object> modelMap = new HashMap<>();

	Object getParameter(String parameterName) {
		return modelMap.get(parameterName);
	}

	void putParameter(String parameterName, Object object) {
		modelMap.put(parameterName, object);
	}
}
