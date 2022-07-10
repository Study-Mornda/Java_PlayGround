public class JudgeResult {
    private int ball;
    private int strike;

    public JudgeResult(int strike, int ball) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
