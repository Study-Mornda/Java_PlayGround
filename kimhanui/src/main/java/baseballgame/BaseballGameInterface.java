package baseballgame;

public interface BaseballGameInterface {
    String inputNumber();
    int cntBall(int[] cntAr,  String input);
    int  cntStrike(int[] cntAr,  String input);
    String printTriedResult(int ballCnt,int strikeCnt);
}
