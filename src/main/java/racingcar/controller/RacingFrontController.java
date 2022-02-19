package racingcar.controller;

import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleResultView;

public class RacingFrontController {
	private final Controller carCreateController;
	private final Controller carRunController;

	public RacingFrontController() {
		this.carCreateController = new CarCreateController();
		this.carRunController = new CarRunController();
	}

	public void service() {
		ModelAndView mv = new ModelAndView(new ConsoleInputView(), new ConsoleResultView());
		exceptionHandleProcess(carCreateController, mv);
		exceptionHandleProcess(carRunController, mv);
	}

	private void exceptionHandleProcess(Controller controller, ModelAndView mv) {
		try {
			controller.process(mv);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			exceptionHandleProcess(controller, mv);
		}
	}
}
