import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RefereeTest {

    @DisplayName("입력값이 3자리가 아니라면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest(name = "입력값: {0}일때 예외 발생")
    @ValueSource(strings = {"12", "1234"})
    void validateNumber(String input) {
        // given, when, that
        assertThatThrownBy(() -> {
            Referee referee = new Referee(split(input));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 3자리여야 합니다.");
    }

    @DisplayName("심판은 같은 수가 같은 자리에 있으면 스트라이크임을 알려줘야 한다.")
    @ParameterizedTest(name = "실제 값: {1}, 추측 값: {2}, 스트라이크 개수: {0}")
    @CsvSource(value = {
            "0,123,234",
            "1,123,134",
            "2,123,124",
            "3,123,123"
    }, delimiter = ',')
    void countStrike(int actual, String answer, String guess) {
        // given
        Referee referee = new Referee(split(answer));

        // when
        int expected = referee.countStrike(split(guess));

        // that
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("심판은 같은 수가 다른 자리에 있으면 볼임을 알랴줘야 한다.")
    @ParameterizedTest(name = "실제 값: {1}, 추측 값: {2}, 볼 개수: {0}")
    @CsvSource(value = {
            "0,123,123",
            "1,123,345",
            "2,123,321",
            "3,123,312"
    }, delimiter = ',')
    void countBall(int actual, String answer, String guess) {
        // given
        Referee referee = new Referee(split(answer));

        // when
        int expected = referee.countBall(split(guess));

        // that
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("심판은 스트라이크와 볼의 개수를 알려줘야 한다.")
    @ParameterizedTest(name = "실제 값: {0}, 추측 값: {1}, 스트라이크 개수: {2}, 볼 개수: {3}")
    @CsvSource(value = {
            "425,123,1,0",
            "425,456,1,1",
            "425,789,0,0"
    }, delimiter = ',')
    void judge(String answer, String guess, int actualStrike, int actualBall) {
        // given
        Referee referee = new Referee(split(answer));

        // when
        JudgeResult expected = referee.judge(split(guess));

        // that
        assertThat(actualStrike).isEqualTo(expected.getStrike());
        assertThat(actualBall).isEqualTo(expected.getBall());
    }

    private List<Integer> split(String number) {
        return number.chars().boxed()
                .map(e -> e - '0')
                .collect(Collectors.toList());
    }

}
