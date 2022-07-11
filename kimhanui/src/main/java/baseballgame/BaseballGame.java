package baseballgame;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballGame {
    private String answer = "";
    private int[] strikeAr;
    private int[] ballAr;
    public BaseballGame(){
        while(true) {
            setAnswer();
            String input = inputNumber();
            strikeAr = new int[10];
            ballAr = new int[10];
            int strikeCnt = cntStrike(strikeAr, input);
            int ballCnt = cntBall(ballAr, input);
            String retryYN = printTriedResult(ballCnt, strikeCnt);
            if(retryYN.equals("2")) return;
        }
    }

    void setAnswer(){
        String newAnswer = "";
        for(int i=0;i<3;i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 10);
            newAnswer = newAnswer.concat(String.valueOf(randomNum));
        }
        answer = newAnswer;
    }

    String inputNumber(){
        String outputMsg = "숫자를 입력해 주세요 : ";
        System.out.print(outputMsg);

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private String printTriedResult(int ballCnt, int strikeCnt){
        System.out.print(printResult(ballCnt,strikeCnt));
        if(strikeCnt == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }
        return "";
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

    private int cntStrike(int[] cntAr, String tried){
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

    private int cntBall(int[] ballAr, String tried){
        for(int i=0;i<3;i++){
            int n1 = answer.charAt(i)-'0';
            cntBallForOne(ballAr, n1, tried);
        }
        return Arrays.stream(ballAr).sum();
    }

    private void cntBallForOne(int[] ballAr, int n1, String s2){
        if(strikeAr[n1] > 0) return;
        for(int i=0;i<3;i++){
            int n2 = s2.charAt(i)-'0';
            cntSame(ballAr, n1, n2);
        }
    }
}
