package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameJudgeTest {

    @Test
    @DisplayName("countBall: 위치 다른 동일 숫자만 카운트")
    void countBall_countsOnlyDifferentPositions() {
        BaseballGameJudge judge = new BaseballGameJudge();

        int ball = judge.countBall(List.of(1, 2, 3), List.of(2, 1, 3));

        assertThat(ball).isEqualTo(2);
    }

    @Test
    @DisplayName("countBall: 스트라이크는 볼로 카운트하지 않음")
    void countBall_doesNotCountStrikeAsBall() {
        BaseballGameJudge judge = new BaseballGameJudge();

        int ball = judge.countBall(List.of(1, 2, 3), List.of(1, 3, 2));

        assertThat(ball).isEqualTo(2);
    }

    @Test
    @DisplayName("countStrike: 같은 위치 같은 숫자 카운트")
    void countStrike_countsSamePositionSameNumber() {
        BaseballGameJudge judge = new BaseballGameJudge();

        int strike = judge.countStrike(List.of(1, 2, 3), List.of(1, 4, 3));

        assertThat(strike).isEqualTo(2);
    }

    @Test
    @DisplayName("countStrike: 전부 일치 시 길이 반환")
    void countStrike_returnsLengthWhenAllMatch() {
        BaseballGameJudge judge = new BaseballGameJudge();

        int strike = judge.countStrike(List.of(7, 8, 9), List.of(7, 8, 9));

        assertThat(strike).isEqualTo(3);
    }

    @Test
    @DisplayName("judge: 볼/스트라이크 계산")
    void judge_returnsBallAndStrikeCounts() {
        BaseballGameJudge judge = new BaseballGameJudge();

        GameResult result = judge.judge(List.of(4, 2, 5), List.of(2, 4, 5));

        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("judge: 일치 없음이면 0/0")
    void judge_returnsZeroWhenNoMatches() {
        BaseballGameJudge judge = new BaseballGameJudge();

        GameResult result = judge.judge(List.of(1, 2, 3), List.of(4, 5, 6));

        assertThat(result.getBall()).isZero();
        assertThat(result.getStrike()).isZero();
    }
}
