package laddergame.domain;

import laddergame.fixture.NamesFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("이름 목록")
class NamesTest {
    @DisplayName("생성된다.")
    @ParameterizedTest(name = "names = {0}")
    @MethodSource("namesDummy")
    void create(final List<String> names) {
        assertDoesNotThrow(() -> new Names(names));
    }

    @DisplayName("Name 리스트가 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenNamesIsNull() {
        final List<String> names = null;

        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Name 리스트가 2명 미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("namesWrongParameterDummy")
    void throwExceptionWhenNamesHasSizeLessThan2(final List<String> names) {
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Name 리스트의 크기를 가져온다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void getSize(final List<String> inputNames) {
        final Names names = new Names(inputNames);
        final int inputNamesSize = inputNames.size();
        final int createdNamesSize = names.getSize();

        assertThat(createdNamesSize).isEqualTo(inputNamesSize);
    }

    @DisplayName("Name 리스트를 가져온다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void getNames(final List<String> inputNames) {
        final Names names = new Names(inputNames);
        final List<String> findNames = names.getNames()
                .stream()
                .map(Name::getValue)
                .collect(Collectors.toList());

        assertThat(findNames).containsExactlyElementsOf(inputNames);
    }

    @DisplayName("Name 값 리스트를 가져온다.")
    @ParameterizedTest
    @MethodSource("namesDummy")
    void getNameValues(final List<String> inputNames) {
        final Names names = new Names(inputNames);
        final List<String> findNames = names.getNameValues();

        assertThat(findNames).containsExactlyElementsOf(inputNames);
    }

    @DisplayName("Names 리스트에서 이름을 통해서 현재 위치를 검색할 수 있다.")
    @Test
    void findPositionByName() {
        final Names names = NamesFixture.createNames(3);
        final int positionValue = 1;
        final String nameValue = names.getNameValues().get(positionValue);
        final Position findPosition = names.findPositionByName(nameValue);

        assertThat(findPosition.getValue()).isEqualTo(positionValue);
    }

    @DisplayName("현재 위치를 통해서 Name을 검색할 수 있다.")
    @Test
    void findNameByPosition() {
        final Names names = NamesFixture.createNames(3);
        final Position position = new Position(1);
        final String nameValue = names.getNameValues().get(position.getValue());
        final Name findName = names.findNameByPosition(position);

        assertThat(findName.getValue()).isEqualTo(nameValue);
    }

    static Stream<Arguments> namesWrongParameterDummy() {
        return Stream.of(
                Arguments.arguments(List.of("name0")),
                Arguments.arguments(List.of("name1")),
                Arguments.arguments(List.of("name2"))
        );
    }

    static Stream<Arguments> namesDummy() {
        return Stream.of(
                Arguments.arguments(List.of("name0", "name1")),
                Arguments.arguments(List.of("name0", "name1")),
                Arguments.arguments(List.of("name0", "name1")),
                Arguments.arguments(List.of("name0", "name1", "name2"))
        );
    }
}