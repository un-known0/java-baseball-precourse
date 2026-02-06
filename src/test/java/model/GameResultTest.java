package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    @DisplayName("getter: 생성자 값 반환")
    void getters_returnConstructorValues() {
        GameResult result = new GameResult(2, 1);

        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("isGameOver: strike==size면 true")
    void isGameOver_returnsTrueWhenStrikeMatchesSize() {
        GameResult result = new GameResult(0, 3);

        assertThat(result.isGameOver(3)).isTrue();
    }

    @Test
    @DisplayName("isGameOver: strike!=size면 false")
    void isGameOver_returnsFalseWhenStrikeDoesNotMatchSize() {
        GameResult result = new GameResult(1, 2);

        assertThat(result.isGameOver(3)).isFalse();
    }

    @Test
    @DisplayName("isGameOver: size=0, strike=0이면 true")
    void isGameOver_returnsTrueWhenSizeIsZeroAndStrikeIsZero() {
        GameResult result = new GameResult(0, 0);

        assertThat(result.isGameOver(0)).isTrue();
    }
}
