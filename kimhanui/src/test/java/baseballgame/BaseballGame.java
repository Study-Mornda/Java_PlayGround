package baseballgame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * [2] 숫자야구게임 구현
 */
public class BaseballGame {

    //11:02
    //상대받(컴퓨터)의 역할을 짜면 될 듯 함
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";

    @ParameterizedTest
    @CsvSource(value={"123:123:3"}, delimiter=':')
    void isStrikeOrNotTest(String answer, String tried, String expected){
        int strikeCnt = 0;
        for(int i=0;i<3;i++){
            int n1 = answer.charAt(i)-'a';
            int n2 = tried.charAt(i)-'a';
            strikeCnt += cntStrike(n1, n2);
        }
        assertThat(strikeCnt).isEqualTo(parseInt(expected));
    }

    private int cntStrike(int n1, int n2){
        if(n1 == n2) return 1;
        return 0;
    }
}
