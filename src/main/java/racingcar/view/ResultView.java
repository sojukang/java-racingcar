package racingcar.view;

import java.util.List;

import racingcar.model.CarDto;

public interface ResultView {
	void printBeforeGameResult();

	void printGameResult(List<CarDto> cars);

	void printWinners(List<CarDto> cars);
}
