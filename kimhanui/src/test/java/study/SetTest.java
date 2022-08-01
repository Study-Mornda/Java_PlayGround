package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * [0] 학습테스트 실습 - Set Collection 클래스
 */
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void requirement1(){
        assertThat(numbers.size()).isEqualTo(4);
    }

    /**
     * 중복해서 발생하는 로직, 코드는 parameterized test로 대응할 수 있다.
     */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void requirement2_hint(int e){
        assertThat(numbers).contains(e);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void requirement3(String number, String expected_yn){
        int e = parseInt(number);
        boolean expected = parseBoolean(expected_yn);
        assertThat(numbers.contains(e)).isEqualTo(expected);
    }
}
