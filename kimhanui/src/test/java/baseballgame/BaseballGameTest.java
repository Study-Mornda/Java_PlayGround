package baseballgame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * [2] 숫자야구게임 구현
 */
public class BaseballGameTest { // TODO: 책임 분리 필요
    int[] strikeCnt;
    int[] ballCnt;

    @ParameterizedTest
    @CsvSource(value={"123:123:3", "123:222:1", "123:342:0"}, delimiter=':')
    void cntStrikeTest(String answer, String tried, String expected){
        int[] cntAr = new int[10];
        int strikeCnt = cntStrike(cntAr, answer, tried);
        assertThat(strikeCnt).isEqualTo(parseInt(expected));
    }

    @ParameterizedTest(name = "정답:{0}, 시도한 값:{1}일 경우, 볼 개수:{2}")
    @CsvSource(value={"123:444:0", "123:245:1", "123:342:2", "123:123:0"}, delimiter=':')
    void cntBallTest(String answer, String tried, String expected){
        strikeCnt = new int[10];
        ballCnt = new int[10];
        int actualBallCnt = cntBall(ballCnt, answer, tried);
        assertThat(actualBallCnt).isEqualTo(parseInt(expected));
        strikeCnt = null;
        ballCnt= null;
    }

    /**
     * csvSource에서 \n 못읽음 (이유 모름)
     */
    @ParameterizedTest
    @ValueSource(strings = {"0:0:낫싱", "1:1:1볼 1스트라이크\n", "3:0:3볼\n", "0:3:3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"})
    void printTriedResultTest(String input){
        //given
        String[] inputs = input.split(":");
        int ballCnt = parseInt(inputs[0]);
        int strikeCnt = parseInt(inputs[1]);
        String result = inputs[2];

        //when
        String expected = printTriedResult(ballCnt, strikeCnt);

        //then
        assertThat(expected).isEqualTo(result);
    }

    private int cntStrike(int[] cntAr, String answer, String tried){
        for(int i=0;i<3;i++){
            int n1 = answer.charAt(i)-'0';
            int n2 = tried.charAt(i)-'0';
            cntSame(cntAr, n1, n2);
        }
        return Arrays.stream(cntAr).sum();
    }

    private void cntSame(int[] cntAr, int n1, int n2){ // if-else문 때문에 depth 1초과되므로 메서드로 분리
        if(n1 == n2) cntAr[n1]++;
    }

    private int cntBall(int[] cntAr, String answer, String tried){
        cntStrike(strikeCnt, answer, tried);
        for(int i=0;i<3;i++){
            int n1 = answer.charAt(i)-'0';
            cntBallForOne(ballCnt, n1, tried);
        }
        return Arrays.stream(cntAr).sum();
    }

    /**
     * 같은 숫자에 대해 cnt 중복 합산 피하기위해 ballCnt(1D int array)사용
     */
    private void cntBallForOne(int[] ballCnt, int n1, String s2){
        if(strikeCnt[n1] > 0) return;
        for(int i=0;i<3;i++){
            int n2 = s2.charAt(i)-'0';
            cntSame(ballCnt, n1, n2);
        }
    }

    private String printTriedResult(int ballCnt, int strikeCnt){
        String expected = printResult(ballCnt,strikeCnt);
        if(strikeCnt == 3){
            expected = expected + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

            String input = "2";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
        }
        return expected;
    }
    private String printResult(int ballCnt, int strikeCnt){
        String expected = "";
        if(ballCnt==0 && strikeCnt == 0) {
            return "낫싱";
        }
        if(ballCnt>0) {
            expected = concat(expected, ballCnt+"볼");
        }
        if(strikeCnt>0) {
            expected = concat(expected, strikeCnt+"스트라이크");
        }
        return expected+"\n";
    }
    private String concat(String s1, String s2){
        if(s1.length()>1){
            return s1.concat(" "+s2);
        }
        return s2;
    }
}
