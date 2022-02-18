package racingcar.controller;

import java.util.List;

import racingcar.model.CarDto;
import racingcar.view.ResultView;

public class RacingFrontController {
	private final Controller carRunController;
	private final Controller carCreateController;

	public RacingFrontController() {
		this.carRunController = new CarRunController();
		this.carCreateController = new CarCreateController();
	}

	public void service() {
		ModelMap modelMap = new ModelMap();
		exceptionHandleProcess(carCreateController, modelMap);
		exceptionHandleProcess(carRunController, modelMap);
		List<CarDto> winners = (List<CarDto>)modelMap.getParameter("winners");
		ResultView.printWinners(winners);
	}

	private void exceptionHandleProcess(Controller controller, ModelMap modelMap) {
		try {
			controller.process(modelMap);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			exceptionHandleProcess(controller, modelMap);
		}
	}
}
