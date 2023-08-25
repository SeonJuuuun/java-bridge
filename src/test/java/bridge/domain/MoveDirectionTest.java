package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveDirectionTest {

    @DisplayName("1로 값을주면 U로 반환하는 테스트")
    @Test
    void 메서드에_1이_넣어지면_U로_반환테스트() throws Exception {
        assertThat(MoveDirection.getDirectionFromMove(1)).isEqualTo("U");
    }

    @DisplayName("0과 1이 아닌 다른 값이 들어오면 예외를 발생한다.")
    @Test
    void 범위의_값이_아닌_다른값_예외_테스트() {
        assertThatThrownBy(() -> MoveDirection.getDirectionFromMove(3))
            .isInstanceOf(IllegalArgumentException.class);
    }
}