package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("pickNumber: 범위 내 값 반환")
    void pickNumber_returnsValueWithinRange() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        for (int i = 0; i < 100; i++) {
            int value = generator.pickNumber(1, 9);
            assertThat(value).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("pickNumber: start==end이면 해당 값 반환")
    void pickNumber_returnsStartWhenRangeIsSingleValue() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        int value = generator.pickNumber(5, 5);

        assertThat(value).isEqualTo(5);
    }

    @Test
    @DisplayName("pickNumber: start가 end보다 크면 예외")
    void pickNumber_throwsWhenStartGreaterThanEnd() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        assertThatThrownBy(() -> generator.pickNumber(5, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("pickUniqueNumbers: count가 0이면 빈 리스트")
    void pickUniqueNumbers_returnsEmptyListWhenCountIsZero() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        List<Integer> numbers = generator.pickUniqueNumbers(1, 9, 0);

        assertThat(numbers).isEmpty();
    }

    @Test
    @DisplayName("pickUniqueNumbers: 범위 내 중복 없는 리스트")
    void pickUniqueNumbers_returnsUniqueNumbersWithinRange() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        List<Integer> numbers = generator.pickUniqueNumbers(1, 9, 3);

        assertThat(numbers).hasSize(3);
        assertThat(numbers).allSatisfy(n -> assertThat(n).isBetween(1, 9));
        Set<Integer> unique = new HashSet<>(numbers);
        assertThat(unique).hasSize(3);
    }

    @Test
    @DisplayName("pickUniqueNumbers: 범위보다 많은 개수면 예외")
    void pickUniqueNumbers_throwsWhenCountExceedsRange() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        assertThatThrownBy(() -> generator.pickUniqueNumbers(1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("pickUniqueNumbers: count가 음수면 예외")
    void pickUniqueNumbers_throwsWhenCountIsNegative() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        assertThatThrownBy(() -> generator.pickUniqueNumbers(1, 9, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("pickUniqueNumbers: start>end이고 count>0이면 예외")
    void pickUniqueNumbers_throwsWhenStartGreaterThanEndAndCountPositive() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        assertThatThrownBy(() -> generator.pickUniqueNumbers(5, 3, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
