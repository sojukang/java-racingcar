package racingcar.controller;

import java.util.stream.Stream;

import racingcar.model.Cars;

class CarCreateController implements Controller {
	private static final String CAR_NAME_DELIMITER = ",";

	private final Cars cars = Cars.INSTANCE;

	@Override
	public void process(ModelAndView mv) {
		String[] carNames = carNamesFormatter(mv.getInputView().getCarNames());
		cars.createCars(carNames);
	}

	private String[] carNamesFormatter(String input) {
		return Stream.of(input.split(CAR_NAME_DELIMITER))
			.map(String::trim)
			.toArray(String[]::new);
	}
}
