package racingcar;

import racingcar.controller.RacingFrontController;

public class ApplicationMain {
	public static void main(String[] args) {
		RacingFrontController racingFrontController = new RacingFrontController();
		racingFrontController.createCarsByUserInput();
		racingFrontController.startGame();
	}
}
