import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {

    @DisplayName("출제자는 1에서 9까지 서로 다른 임의의 수 3개를 선택해 출력해야 한다.")
    @Test
    void generateNumber() {
        // given
        Generator generator = new Generator();

        // when
        List<Integer> expected = generator.pickedNumber();

        // that
        assertThat(3).isEqualTo(expected.size());
    }

}
