package racingcar.controller;

import java.util.List;

import racingcar.model.CarDto;
import racingcar.model.CarToCarDtoMapper;
import racingcar.model.Cars;
import racingcar.model.Random;

class CarController {
	private final Cars cars;
	private final Random random;

	CarController() {
		this.cars = new Cars();
		this.random = new Random();
	}

	void createCars(String[] carNames) {
		cars.createCars(carNames);
	}

	void run() {
		int numberOfCars = cars.getSize();
		cars.moveAll(random.createNumbers(numberOfCars));
	}

	List<CarDto> getCars() {
		return CarToCarDtoMapper.carsToCarDtos(cars.getCars());
	}

	List<CarDto> getWinners() {
		return CarToCarDtoMapper.carsToCarDtos(cars.getWinners());
	}
}
