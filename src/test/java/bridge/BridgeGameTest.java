package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        List<String> bridge = Arrays.asList("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("라운드 마다 사용자의 입력을 받아 맞는 위치인지 확인하고 라운드 수도 확인하는 테스트")
    @Test
    void move_테스트() throws Exception {
        // round 1
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.getRound()).isEqualTo(1);
        // round 2
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.getRound()).isEqualTo(2);
        // round 3
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.getRound()).isEqualTo(3);
    }
}
