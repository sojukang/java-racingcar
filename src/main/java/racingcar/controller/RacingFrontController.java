package racingcar.controller;

import java.util.stream.IntStream;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingFrontController {
	private final CarController carController;

	public RacingFrontController() {
		this.carController = new CarController();
	}

	public void createCarsByUserInput() {
		try {
			carController.createCars(InputView.getCarNames());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			createCarsByUserInput();
		}
	}

	public void startGame() {
		int iteration = InputView.getIterationNumber();
		ResultView.printBeforeGameResult();
		runInIteration(iteration);
		ResultView.printWinners(carController.getWinners());
	}

	private void runInIteration(int iteration) {
		IntStream.range(0, iteration).forEach(i -> {
			carController.run();
			ResultView.printGameResult(carController.getCars());
		});
	}
}
