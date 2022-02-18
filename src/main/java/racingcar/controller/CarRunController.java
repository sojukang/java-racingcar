package racingcar.controller;

import java.util.List;

import racingcar.model.CarDto;
import racingcar.model.CarToCarDtoMapper;
import racingcar.model.Cars;
import racingcar.model.Random;
import racingcar.view.InputView;
import racingcar.view.ResultView;

class CarRunController implements Controller {
	private final Random random;
	private Cars cars;

	CarRunController() {
		this.random = new Random();
	}

	@Override
	public void process(ModelMap modelMap) {
		cars = (Cars)modelMap.getParameter("cars");
		int iteration = InputView.getIterationNumber();
		ResultView.printBeforeGameResult();
		for (int i = 0; i < iteration; i++) {
			run();
			ResultView.printGameResult(getCars());
		}
		modelMap.putParameter("winners", getWinners());
	}

	private void run() {
		cars.moveAll(random.createNumbers(cars.getSize()));
	}

	private List<CarDto> getCars() {
		return CarToCarDtoMapper.carsToCarDtos(cars.getCars());
	}

	private List<CarDto> getWinners() {
		return CarToCarDtoMapper.carsToCarDtos(cars.getWinners());
	}
}
