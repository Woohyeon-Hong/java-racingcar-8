package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
class CarTest {

    @Test
    void createRaceCarList() {
        //given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        //when
        List<Car> raceCarList = Car.createRaceCarList(carNames);

        //then
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(raceCarList.get(i).getName()).isEqualTo(carNames.get(i));
            assertThat(raceCarList.get(i).getMovedDistance()).isEqualTo(0);
        }
    }
}