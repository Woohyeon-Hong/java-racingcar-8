package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    void findWinners() {
        //given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");

        List<Car> raceCarList = Car.createRaceCarList(carNames);

        //총 10번의 라운드를 진행
        for (int i = 0; i < 10; i++) {
            for (Car car : raceCarList) {
                car.move();
            }
        }

        //when
        List<Car> winners = Car.findWinners(raceCarList);

        //then
        for (Car winner : winners) {
            System.out.print(winner.getName() + " ");
        }
    }
}