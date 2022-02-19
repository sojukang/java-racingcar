package racingcar.controller;

import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleResultView;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingFrontController {
	private final Controller carCreateController;
	private final Controller carRunController;

	public RacingFrontController() {
		this.carCreateController = new CarCreateController();
		this.carRunController = new CarRunController();
	}

	public void service() {
		InputView inputView = new ConsoleInputView();
		ResultView resultView = new ConsoleResultView();
		exceptionHandleProcess(carCreateController, inputView, resultView);
		exceptionHandleProcess(carRunController, inputView, resultView);
	}

	private void exceptionHandleProcess(Controller controller, InputView inputView, ResultView resultView) {
		try {
			controller.process(inputView, resultView);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			exceptionHandleProcess(controller, inputView, resultView);
		}
	}
}
