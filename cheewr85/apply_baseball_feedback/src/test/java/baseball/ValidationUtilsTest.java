package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("1 ~ 9의 숫자인지 검증")
    void validationTest() {
        assertThat(ValidationUtils.validNumber(7)).isTrue();
        assertThat(ValidationUtils.validNumber(9)).isTrue();
        assertThat(ValidationUtils.validNumber(0)).isFalse();
        assertThat(ValidationUtils.validNumber(10)).isFalse();
    }
}
