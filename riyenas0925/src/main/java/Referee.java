import java.util.List;

public class Referee {
    private List<Integer> answer;

    public Referee(List<Integer> answer) {
        validateNumber(answer);
        this.answer = answer;
    }

    private void validateNumber(List<Integer> number) {
        if(number.size() != 3)
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
    }
}
