package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
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

    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            movedDistance++;
        }
    }
}
