package racingcar;

import java.util.List;
import racingcar.model.Car;
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
        List<Car> carList = inputView.inputCarNames();
        outputView.printTotalRoundPrompt();
        int totalRounds = inputView.inputTotalRounds();
        outputView.printRaceProgressPrompt();

        for (int i = 0; i < totalRounds; i++) {
            for (Car car : carList) {
                outputView.printCarName(car);
                car.move();
                outputView.printCarMovement(car);
            }
            System.out.println();
        }
    }
}
