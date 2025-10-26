package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
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
    public static List<Car> findWinners(List<Car> carList) {
        List<Car> winners = new ArrayList<>();
        int maxMovedDistance = getMaxMovedDistance(carList);

        //maxMovedDistance와 같은 거리를 이동한 모든 우승자들을 winners에 추가
        for (Car car : carList) {
            if (car.getMovedDistance() < maxMovedDistance) break;
            winners.add(car);
        }
        return winners;
    }

    private static int getMaxMovedDistance(List<Car> carList) {
        //movedDistance를 기준으로 내림차순 정렬 & 가장 멀리 이동한 자동차의 movedDistance 반환
        carList.sort(Comparator.comparing(Car::getMovedDistance).reversed());
        return carList.get(0).getMovedDistance();
    }

    //------------------------------------------------------------------------------
    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            movedDistance++;
        }
    }
}
