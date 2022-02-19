package racingcar.controller;

import java.util.stream.Stream;

class Formatter {
	private static final String CAR_NAME_DELIMITER = ",";

	private Formatter() {
	}

	static String[] splitAndTrim(String input) {
		return Stream.of(input.split(CAR_NAME_DELIMITER))
			.map(String::trim)
			.toArray(String[]::new);
	}
}
