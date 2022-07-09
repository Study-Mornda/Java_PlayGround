import java.util.Scanner;

public class Baseball {

    int[] randomNumber = new int[3];
    int[] assumeNumber = new int[3];
    int strike = 0, ball = 0;

    void inputView() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        for(int i = 0; i < assumeNumber.length; i++) {
            assumeNumber[i] = sc.nextInt();
        }
    }

    int[] makeRandomNumber() {
        for (int i = 0; i < randomNumber.length; i++) {
            double rand = Math.random();
            randomNumber[i] = (int)(rand * 10);
//            zeroCheck();
//            i = validCheck(i);
        }
        return randomNumber;
    }

    int zeroCheck() {
        if (randomNumber[0] == 0) {
            randomNumber[0] = (int)(Math.random() * 10);
        }
        return randomNumber[0];
    }

    int validCheck(int idx) {
        int tmp = idx;
        for (int j = 0; j < idx; j++) {
            tmp = doubleCheck(j, idx);
        }
        return tmp;
    }

    int doubleCheck(int i, int j) {
        int tmp = i;
        if (randomNumber[j] == randomNumber[i]) {
            tmp = j;
            tmp--;
        }
        return tmp;
    }

    void numberBaseball() {
        while(true) {
            inputView();
            numberCheck();
            resultView();
        }
    }

    void numberCheck() {
        for (int i = 0; i < randomNumber.length; i++) {
            strikeOrBall(i);
        }
    }

    void strikeOrBall(int ran) {
        for (int i = 0; i < assumeNumber.length; i++) {
            strike(ran, i);
            ball(ran, i);
        }
    }

    int strike(int ran, int ass) {
        if (randomNumber[ran] == assumeNumber[ass] && ran == ass) {
            strike++;
        }
        return strike;
    }

    int ball(int ran, int ass) {
        if (randomNumber[ran] == assumeNumber[ass] && ran != ass) {
            ball++;
        }
        return ball;
    }

    void resultView() {
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike != 0 && ball != 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }

        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }

        if (strike != 0 && ball != 0) {
            System.out.println("낫싱");
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            Scanner sc = new Scanner(System.in);
            updateGame(sc.nextInt());
        }
    }

    void updateGame(int num) {
        if (num == 1) {
            numberBaseball();
        }

        if (num == 2) {
            System.exit(0);
        }
    }




}
