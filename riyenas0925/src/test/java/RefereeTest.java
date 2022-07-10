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

    private List<Integer> split(String number) {
        return number.chars().boxed()
                .map(e -> e - '0')
                .collect(Collectors.toList());
    }

}
