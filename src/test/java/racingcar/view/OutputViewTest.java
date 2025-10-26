package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void printStartPrompt() {
        outputView.printCarNameInputPrompt();
    }

    @Test
    void printRaceProgressPrompt() {
        outputView.printRaceStartPrompt();
    }

    @Test
    void printRaceResult() {
        //given
        List<String> multipleWinnerNames = new ArrayList<>();
        multipleWinnerNames.add("car1");
        multipleWinnerNames.add("car2");
        multipleWinnerNames.add("car3");

        List<Car> multipleWinners = Car.createRaceCarList(multipleWinnerNames);

        List<String> oneWinnerName = new ArrayList<>();
        oneWinnerName.add("car1");

        List<Car> oneWinner = Car.createRaceCarList(oneWinnerName);

        //when & then
        System.out.println("multiple winners:");
        outputView.printRaceResult(multipleWinners);
        System.out.println();

        System.out.println("only one winner");
        outputView.printRaceResult(oneWinner);
    }
}