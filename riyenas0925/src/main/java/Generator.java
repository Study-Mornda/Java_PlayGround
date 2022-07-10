import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private List<Integer> pickedNumber;

    public Generator() {
        pickedNumber = new ArrayList<>();
    }

    public List<Integer> pickedNumber() {
        while(pickedNumber.size() < 3) {
            int number = randNumberExcludeZero();

            if(!containsNumber(number)) {
                pickedNumber.add(number);
            }
        }

        return pickedNumber;
    }

    private int randNumberExcludeZero() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }

    private boolean containsNumber(int number) {
        return pickedNumber.contains(number);
    }

}
