package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * [1] 문자열 계산기
 */
public class StringCalculator {

    /**
     * 우선순위 무시한 사칙연산 계산기 만들기
     * - 반복목 index 홀짝 여부에 따라 계산 -> 조건문이 들어가 indent 초과.
     */
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
    void requirement1(String function, String expected) {
        String[] elements = function.split(" ");
        int size = elements.length;
        int sumValue = parseInt(elements[0]);
        for (int i = 1; i < size - 1; i = i + 2) {
            char operator = elements[i].charAt(0);
            int nextNum = parseInt(elements[i + 1]);
            sumValue = operate(sumValue, nextNum, operator);
        }

        assertThat(sumValue).isEqualTo(parseInt(expected));
    }

    private int operate(int n1, int n2, char operator) {
        if (operator == '+') return n1 + n2;
        if (operator == '-') return n1 - n2;
        if (operator == '*') return n1 * n2;
        if (operator == '/') return n1 / n2;
        throw new IllegalArgumentException("operator is invalid");
    }
}
