package baseball;

public class ValidationUtils {

    public static int MIN_NUM = 1;
    public static int MAX_NUM = 9;

    public static boolean validNumber(int number) {
        return number >= MIN_NUM && number <= MAX_NUM;
    }
}
