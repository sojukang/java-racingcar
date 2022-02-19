package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.ResultView;

interface Controller {
	void process(InputView inputView, ResultView resultView);
}
