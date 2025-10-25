package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String POSITION_INDICATOR = "-";

    public OutputView() {
    }

//프롬프트 출력------------------------------------------------------------------------------------------------
    public void printStartPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTotalRoundPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceProgressPrompt() {
        System.out.println("\n실행 결과");
    }

    public void printRaceResultPrompt() {
        System.out.print("최종 우승자 : ");
    }


//Model 데이터 출력---------------------------------------------------------------------------------------------

    public void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    public void printCarMovement(Car car) {
        int distance = car.getMovedDistance();
        printPositionIndicatorsWith(distance);
        changeLine();
    }

    public void printRaceResult(List<Car> winners) {
        if (isSoleWinner(winners)) {
            printWinnerName(winners.get(0));
            return;
        }

        printWinners(winners);
    }

    private static void printPositionIndicatorsWith(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(POSITION_INDICATOR);
        }
    }

    private static boolean isSoleWinner(List<Car> winners) {
        return winners.size() == 1;
    }

    private static void printWinners(List<Car> winners) {
        for (int i = 0; i < winners.size(); i++) {
            printWinnerName(winners.get(i));
            printComma(winners, i);
        }
        changeLine();
    }

    private static void printWinnerName(Car winner) {
        System.out.print(winner.getName());
    }

    private static void printComma(List<Car> winners, int i) {
        if (i < winners.size() - 1) {
            System.out.print(", ");
        }
    }

    private static void changeLine() {
        System.out.println();
    }

}
