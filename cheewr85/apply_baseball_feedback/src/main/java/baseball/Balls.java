package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> com) {
        this.balls = mapBall(com);
    }

    private static List<Ball> mapBall(List<Integer> com) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, com.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> userBalls) {
        Balls userBall = new Balls(userBalls);
        PlayResult result = new PlayResult();
        for (Ball balls : balls) {
            BallStatus status = userBall.play(balls);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(com -> com.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

}
