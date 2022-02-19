package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

class CarCreateController implements Controller {
	private final Cars cars = Cars.INSTANCE;

	@Override
	public void process(InputView inputView, ResultView resultView) {
		String[] carNames = Formatter.splitAndTrim(inputView.getCarNames());
		cars.createCars(carNames);
	}
}
