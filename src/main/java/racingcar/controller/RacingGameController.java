package racingcar.controller;

import racingcar.accessor.GameAccessor;
import racingcar.accessor.RacingGameAccessor;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.Inputable;
import racingcar.view.OutputView;
import racingcar.view.Outputable;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController implements GameController {
    private final GameAccessor gameAccessor = new RacingGameAccessor();
    private final Inputable inputable;
    private final Outputable outputable;

    /**
     * Outputable과 Inputable을 주입하지 않을 경우 default로 {@link OutputView} 와 {@link InputView} 를 생성합니다.
     */
    public RacingGameController() {
        this(new OutputView(), new InputView());
    }

    public RacingGameController(Outputable outputable, Inputable inputable) {
        this.outputable = outputable;
        this.inputable = inputable;
    }

    @Override
    public void start() {
        List<String> carNames = getUserNames();

        setUpGame(carNames);

        iterateRounds();

        outputable.announceWinners(announceWinners());
    }

    private void setUpGame(List<String> carNames) {
        outputable.printInputNumberOfRoundsMessage();
        gameAccessor.setUpGame(carNames, inputable.getNumberOfRounds());
    }

    private List<String> getUserNames() {
        outputable.printInputCarsNameMessage();
        return inputable.getCarsName()
                .getCarsDto()
                .stream()
                .map(CarDto::getName)
                .collect(Collectors.toList());
    }

    private void iterateRounds() {
        while (!gameAccessor.isEnd()) {
            outputable.printLeaderBoard(progressRound());
        }
    }

    @Override
    public void setUpGame(List<String> carNames, int goalRound) {
        gameAccessor.setUpGame(carNames, goalRound);
    }

    @Override
    public void setUpGame(Cars cars, int goalRound) {
        gameAccessor.setUpGame(cars, goalRound);
    }

    @Override
    public CarsDto progressRound() {
        return gameAccessor.executeRound();
    }

    @Override
    public WinnersDto announceWinners() {
        return gameAccessor.findWinners();
    }
}
