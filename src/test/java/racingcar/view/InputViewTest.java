package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class InputViewTest {

   InputView inputView = new InputView();

    @Test
    void extractCarNames() {
        //given
        String[] corrects = {
                "carA,car1",        // 문자 및 숫자만 사용
                "@@,*car*",         // 특수 문자 사용
                "car 1,@ @",        // 중간에 띄어쓰기
                "\"car\",car2"      // 이스케이프 문자 사용
        };

        String[] wrongs = {
                "name1, ,name2",     // 빈값 사용
                "name1, name",      // 띄어쓰기로 시작
                "name1,name ",      // 띄어쓰기로 끝남
                "name1,over5char",  // 5자 초과
                "name1,name1,name2" // 중복된 이름
        };


        //when & then

        for (String correct : corrects) {
            assertThat(inputView.extractCarNamesFrom(correct).size()).isEqualTo(2);
        }

        for (String wrong : wrongs) {
            assertThatThrownBy(() -> inputView.extractCarNamesFrom(wrong))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}