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

    public boolean isCorrectAnswer() {
        return strike == 3 && ball == 0;
    }

    public String getMessage() {
        if(ball == 0 && strike == 0) return "낫싱";
        else if(ball == 0) return strike + "스트라이크";
        else if(strike == 0) return ball + "볼";
        else return ball + "볼 " + strike + "스트라이크";
    }

}
