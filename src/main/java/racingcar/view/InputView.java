package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class InputView {

    public InputView() {
    }

    public List<Car> inputCarNames() {
        String carNames = Console.readLine();
        List<String> carNameList = extractCarNamesFrom(carNames);
        return createCarList(carNameList);
    }

    public List<String> extractCarNamesFrom(String carNames) {
        List<String> carNameList = getCarNameListFrom(carNames);
        validateCarNameFormat(carNameList);
        validateDuplicate(carNameList);
        return carNameList;
    }


    private List<Car> createCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private static List<String> getCarNameListFrom(String carNames) {
        String[] splits = carNames.split(",");
        for (String split : splits) {
            
        }
        return Arrays.stream(carNames.split(",")).toList();
    }

    private void validateCarNameFormat(List<String> carNameList) {
        for (String carName : carNameList) {
            validateBlank(carName);
            validateSpacing(carName);
            validateLength(carName);
        }
    }

    private void validateDuplicate(List<String> carNameList) {
        Set<String> nameSet = new HashSet<>(carNameList);
        if (nameSet.size() < carNameList.size()) {
            throw new IllegalArgumentException("서로 이름이 중복되는 자동차 이름이 존재합니다.");
        }
    }

    private static void validateBlank(String carName) {
        if (carName.isBlank()) throw new IllegalArgumentException("자동차 이름으로 빈값이 입력됐습니다.");
    }


    private static void validateSpacing(String carName) {
        if (carName.startsWith(" ") || carName.endsWith(" "))  {
            throw new IllegalArgumentException("자동차 이름으로 띄어쓰기로 시작되거나 끝납니다.");
        }
    }

    private static void validateLength(String carName) {
        if (carName.length() > 5) throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
    }
}
