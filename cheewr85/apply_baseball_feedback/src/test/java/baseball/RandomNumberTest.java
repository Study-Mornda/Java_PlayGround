package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    void validateRandomNumberTest() {
        int randomNumber = RandomNumber.makeRandom();
        assertThat(ValidationUtils.validNumber(randomNumber)).isTrue();
    }

    @Test
    void validateBallsTest() {
        List<Integer> com = RandomNumber.makeBalls();
        for (int i = 0; i < 3; i++) {
            assertThat(ValidationUtils.validNumber(com.get(i))).isTrue();
        }

    }
}
