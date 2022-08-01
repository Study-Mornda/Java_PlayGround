package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * [0] 학습테스트 실습 - String 클래스
 */
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 배열로 반환하는 경우 contains 써보기
     */
    @Test
    void replace1_1_hint(){
        String given = "1,2";
        String[] splitted = given.split(",");
        assertThat(splitted).contains("1", "2");
    }

    /**
     * 배열로 반환하는 경우 containsExactly 써보기
     */
    @Test
    void replace1_2_hint(){
        String given = "1";
        String[] splitted = given.split(",");
        assertThat(splitted).containsExactly(new String[]{given});
    }

    @Test
    void replace2_1(){
        String given = "(1,2)";
        String removedBracket = given.substring(1, given.length()-1);
        assertThat(removedBracket).isEqualTo("1,2");
    }

    /**
     * 예외 발생 여부, 종류 확인
     */
    @Test
    void replace3_1(){
        String given = "abc";
        assertThatThrownBy(() -> given.charAt(given.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
