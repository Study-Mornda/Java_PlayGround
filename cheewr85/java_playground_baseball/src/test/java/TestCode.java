import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class TestCode {

    Baseball numberBaseball;

    @BeforeEach
    public void setUp() {
        numberBaseball = new Baseball();
    }

    @Test
    public void zeroCheck() {
        assertThat(numberBaseball.zeroCheck()).isNotEqualTo(0);
    }

    @Test
    public void makeRandom() {
        assertThat(numberBaseball.makeRandomNumber()).isEqualTo(numberBaseball.randomNumber);
    }

    @Test
    public void equalityCheck() {
        numberBaseball.randomNumber = new int[] {1,1,2};
        assertThat(numberBaseball.doubleCheck(0, 1)).isEqualTo(0);
    }

    @Test
    public void strikeCheck() {
        numberBaseball.randomNumber = new int[] {3, 4, 5};
        numberBaseball.assumeNumber = new int[] {3, 5, 6};
        assertThat(numberBaseball.strike(0,0)).isEqualTo(1);
    }

    @Test
    public void ballCheck() {
        numberBaseball.randomNumber = new int[] {3, 4, 5};
        numberBaseball.assumeNumber = new int[] {3, 5, 6};
        assertThat(numberBaseball.ball(2,1)).isEqualTo(1);
    }


}
