package baseball;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomNumber {
    public static int MIN_NUM = 1;
    public static int MAX_NUM = 10;

    public static int makeRandom() {
        return (int) (Math.random() * (MAX_NUM - MIN_NUM)) + MIN_NUM;
    }

    public static List<Integer> makeBalls() {
        HashSet<Integer> validNumber = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            validNumber.add(makeRandom());
        }
        while (validNumber.size() != 3) {
            validNumber.add(makeRandom());
        }
        return new ArrayList<>(validNumber);
    }
}
