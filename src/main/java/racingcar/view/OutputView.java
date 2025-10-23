package racingcar.view;

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
}
