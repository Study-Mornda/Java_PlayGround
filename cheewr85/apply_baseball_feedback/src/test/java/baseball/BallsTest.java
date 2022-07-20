package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void strike() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = com.play(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = com.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls com = new Balls(Arrays.asList(1, 2, 3));
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
