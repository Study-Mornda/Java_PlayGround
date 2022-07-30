import java.util.List;

public class Referee {
    private List<Integer> answer;

    public Referee(List<Integer> answer) {
        validateNumber(answer);
        this.answer = answer;
    }

    public JudgeResult judge(List<Integer> guess) {
        return new JudgeResult(
                countStrike(guess),
                countBall(guess)
        );
    }

    public int countStrike(List<Integer> guess) {
        int cnt = 0;

        for(int i = 0; i < 3; i++) {
            if(guess.get(i) == answer.get(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public int countBall(List<Integer> guess) {
        int cnt = 0;

        for(int i = 0; i < 3; i++) {
            if(!guess.get(i).equals(answer.get(i)) && answer.contains(guess.get(i))) {
                cnt++;
            }
        }

        return cnt;
    }

    private void validateNumber(List<Integer> number) {
        if(number.size() != 3)
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
    }
}
