package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void printStartPrompt() {
        outputView.printStartPrompt();
    }

    @Test
    void printRaceProgressPrompt() {
        outputView.printRaceProgressPrompt();
    }
}