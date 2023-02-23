package laddergame.domain;

import laddergame.fixture.LinesFixture;
import laddergame.fixture.PositionFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("사다리")
class LadderTest {
    @DisplayName("Lines가 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenLinesIsNull() {
        final Lines lines = null;

        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성한다.")
    @Test
    void create() {
        final Lines lines = LinesFixture.createLines(3, 3);

        assertDoesNotThrow(() -> new Ladder(lines));
    }

    @DisplayName("사다리 라인들을 가져올 수 있다.")
    @Test
    void getLines() {
        final Lines lines = LinesFixture.createLines(3, 3);
        final Ladder ladder = new Ladder(lines);
        final Lines findLines = ladder.getLines();

        assertThat(findLines)
                .usingRecursiveComparison()
                .isEqualTo(lines);
    }

    @DisplayName("시작 지점에 대한 결과 지점을 찾는다.")
    @Test
    void findLastDestination() {
        final Position startIndex = PositionFixture.createPosition(0);
        final int expectedIndex = 1;
        final Ladder ladder = new Ladder(LinesFixture.createLines(3, 3));

        final Position lastDestination = ladder.findLastDestination(startIndex);

        assertThat(lastDestination.getValue()).isEqualTo(expectedIndex);
    }
}