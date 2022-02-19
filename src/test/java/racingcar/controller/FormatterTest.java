package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormatterTest {

	@Test
	@DisplayName("콤마 기준 분리, 공백 제거")
	void splitCarNamesTest() {
		String userInputCarNames = "  범고래, 소주캉,   고래  ";

		String[] expected = {"범고래", "소주캉", "고래"};
		assertThat(Formatter.splitAndTrim(userInputCarNames)).isEqualTo(expected);
	}
}
