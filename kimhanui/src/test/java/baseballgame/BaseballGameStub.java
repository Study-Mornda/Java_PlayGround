package baseballgame;

import java.io.*;

public class BaseballGameStub extends BaseballGame implements BaseballGameInterface {

    @Override
    public String inputNumber() {
        //출력
        String outputMsg = "숫자를 입력해 주세요 : ";
        System.out.print(outputMsg);

        //입력
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.out.print(input);
        return input;
    }

    @Override
    public int cntBall(int[] cntAr, String input) {
        return cntBall(cntAr, input);
    }

    @Override
    public int cntStrike(int[] cntAr, String input) {
        return cntStrike(cntAr, input);
    }

    @Override
    public String printTriedResult(int ballCnt, int strikeCnt) {
        return printTriedResult(ballCnt, strikeCnt);
    }
}
