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
        List<Car> carList = setupCarList();
        int totalRounds = setupGameRound();
        playRacing(totalRounds, carList);
        announceWinner(carList);
    }

    private List<Car> setupCarList() {
        outputView.printStartPrompt();
        return inputView.inputCarNames();
    }

    private int setupGameRound() {
        outputView.printTotalRoundPrompt();
        return inputView.inputTotalRounds();
    }

    private void playRacing(int totalRounds, List<Car> carList) {
        outputView.printRaceProgressPrompt();

        for (int i = 0; i < totalRounds; i++) {
            runRaceRound(carList);
        }
    }

    private void runRaceRound(List<Car> carList) {
        for (Car car : carList) {
            outputView.printCarName(car);
            car.move();
            outputView.printCarMovement(car);
        }

        System.out.println();
    }

    private void announceWinner(List<Car> carList) {
        outputView.printRaceResultPrompt();
        List<Car> winners = Car.findWinners(carList);
        outputView.printRaceResult(winners);
    }
}
