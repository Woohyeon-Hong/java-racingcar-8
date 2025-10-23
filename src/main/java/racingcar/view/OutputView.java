package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final String POSITION_INDICATOR = "-";

    public OutputView() {
    }

    public void printStartPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTotalRoundPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceProgressPrompt() {
        System.out.println("\n실행 결과");
    }

    public void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    public void printCarMovement(Car car) {
        int distance = car.getMovedDistance();
        for (int i = 0; i < distance; i++) {
            System.out.print(POSITION_INDICATOR);
        }
        System.out.println();
    }

    public void printRaceResultPrompt() {
        System.out.print("최종 우승자 : ");
    }

    public void printRaceResult(List<Car> winners) {
        if (winners.size() == 1) {
            System.out.println(winners.get(0).getName());
        } else {
            for (int i = 0; i < winners.size(); i++) {
                System.out.print(winners.get(i).getName());
                if (i < winners.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
