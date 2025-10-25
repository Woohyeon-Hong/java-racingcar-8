package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class InputView {

    public InputView() {
    }

    public List<Car> inputCarNames() {
        String input = Console.readLine();
        List<String> carNameList = extractCarNamesFrom(input);
        return Car.createRaceCarList(carNameList);
    }

    public int inputTotalRounds() {
        String input = Console.readLine();
        validatePositiveNumber(input);
        return Integer.parseInt(input);
    }

    public List<String> extractCarNamesFrom(String carNames) {
        List<String> carNameList = createCarNameListFrom(carNames);
        validateCarNameFormat(carNameList);
        validateDuplicate(carNameList);
        return carNameList;
    }

    private void validatePositiveNumber(String input) {
        if (!input.matches("[+-]?\\d+")) {
            throw new IllegalArgumentException("시도할 횟수는 반드시 자연수여야 합니다.");
        }
    }

    private static List<String> createCarNameListFrom(String input) {
        return Arrays
                .stream(input.split(","))
                .toList();
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
