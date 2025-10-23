package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private int movedDistance;

    public static List<Car> createRaceCarList(List<String> carNameList) {
        List<Car> raceCarList = new ArrayList<>();
        for (String carName : carNameList) {
            raceCarList.add(new Car(carName));
        }
        return raceCarList;
    }
    public static List<Car> findWinners(List<Car> carList) {

        List<Car> winners = new ArrayList<>();
        winners.add(carList.get(0));

        for (Car car : carList) {
            int maxDistance = winners.get(0).getMovedDistance();
            if (car.getMovedDistance() > maxDistance) {
                winners = new ArrayList<>();
                winners.add(car);
            } else if (car.getMovedDistance() == maxDistance && !winners.contains(car)) {
                winners.add(car);
            }
        }

        return winners;
    }

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

    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            movedDistance++;
        }
    }
}
