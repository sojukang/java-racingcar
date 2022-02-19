package racingcar.controller;

import java.util.stream.Stream;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

class CarCreateController implements Controller {
	private static final String CAR_NAME_DELIMITER = ",";

	private final Cars cars = Cars.INSTANCE;

	@Override
	public void process(InputView inputView, ResultView resultView) {
		String[] carNames = carNamesFormatter(inputView.getCarNames());
		cars.createCars(carNames);
	}

	private String[] carNamesFormatter(String input) {
		return Stream.of(input.split(CAR_NAME_DELIMITER))
			.map(String::trim)
			.toArray(String[]::new);
	}
}
