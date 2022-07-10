import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RefereeTest {

    @DisplayName("입력값이 3자리가 아니라면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest(name = "{index}: {arguments}")
    @MethodSource("parametersProvider")
    void validateNumber(List<Integer> input) {
        // given, when, that
        assertThatThrownBy(() -> {
            Referee referee = new Referee(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 3자리여야 합니다.");
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4)),
                arguments(Arrays.asList(1, 2))
        );
    }
}
