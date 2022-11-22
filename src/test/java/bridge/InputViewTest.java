package bridge;

import bridge.controller.InputViewException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bridge.controller.InputViewException.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private final InputViewException inputViewException = new InputViewException();


    @DisplayName("다리 길이 입력에 대한 예외 테스트")
    @ParameterizedTest
    @MethodSource("readBridgeSizeParam")
    void readBridgeSize(String bridgeSize, String exception) {
        assertThatThrownBy(() -> inputViewException.readBridgeSizeException(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exception);
    }

    static Stream<Arguments> readBridgeSizeParam() {
        return Stream.of(
                Arguments.of("", error01),
                Arguments.of("5d", error02),
                Arguments.of("2", error03),
                Arguments.of("21", error03)
        );
    }




    @DisplayName("이동할 칸 입력에 대한 예외 테스트")
    @ParameterizedTest
    @MethodSource("readMovingParam")
    void readMoving(String playerMove, String exception) {
        assertThatThrownBy(() -> inputViewException.readMovingException(playerMove))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exception);
    }

    static Stream<Arguments> readMovingParam() {

    }

    void readGameCommand(String playerCommand, String exception) {

    }
}
