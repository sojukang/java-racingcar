package racingcar.controller;

import java.util.List;

import racingcar.model.CarDto;
import racingcar.model.CarToCarDtoMapper;
import racingcar.model.Cars;
import racingcar.model.Random;

class CarRunController implements Controller {
	private final Random random;
	private final Cars cars = Cars.INSTANCE;

	CarRunController() {
		this.random = new Random();
	}

	@Override
	public void process(ModelAndView mv) {
		int iteration = mv.getInputView().getIterationNumber();
		mv.getResultView().printBeforeGameResult();

		for (int i = 0; i < iteration; i++) {
			run();
			mv.getResultView().printGameResult(getCars());
		}

		mv.getResultView().printWinners(getWinners());
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
