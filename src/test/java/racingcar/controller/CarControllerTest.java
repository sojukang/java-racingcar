package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarControllerTest {
	@Test
	@DisplayName("3대의 자동차 목록 생성 테스트")
	void createCarsTest() {
		CarController carController = new CarController();
		String[] userInputCarNames = {"범고래", "소주캉", "고래"};
		carController.createCars(userInputCarNames);

		assertThat(carController.getCars().size()).isEqualTo(3);
	}
}
