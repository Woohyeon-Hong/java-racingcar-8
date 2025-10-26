package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
        this.movedDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }


//static 메서드------------------------------------------------------------------------------
    public static List<Car> createRaceCarList(List<String> carNameList) {
        List<Car> raceCarList = new ArrayList<>();
        carNameList
                .forEach((carName) -> raceCarList.add(new Car(carName)));
        return raceCarList;
    }
    public static List<Car> findFinalWinners(List<Car> carList) {
        List<Car> winners = new ArrayList<>();
        int maxMovedDistance = getMaxMovedDistance(carList);

        //maxMovedDistance와 같은 거리를 이동한 모든 우승자들을 winners에 추가
        return carList.stream()
                .filter(c -> c.getMovedDistance() == maxMovedDistance)
                .toList();
    }

    private static int getMaxMovedDistance(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElse(0);
    }

    //------------------------------------------------------------------------------
    public void runRound() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            movedDistance++;
        }
    }
}
