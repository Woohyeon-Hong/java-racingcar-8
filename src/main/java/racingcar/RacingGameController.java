package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartPrompt();
        inputView.inputCarNames();
        outputView.printTotalRoundPrompt();
        inputView.inputTotalRounds();
        outputView.printRaceProgressPrompt();
    }
}
