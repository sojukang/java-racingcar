package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingFrontController {
	private final Controller carRunController;
	private final Controller carCreateController;

	public RacingFrontController() {
		this.carRunController = new CarRunController();
		this.carCreateController = new CarCreateController();
	}

	public void service() {
		ModelAndView mv = new ModelAndView(new InputView(), new ResultView());
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
