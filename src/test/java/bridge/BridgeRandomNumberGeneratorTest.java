package bridge;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("BridgeRandomNumberGenerator 클래스 테스트")
    @Test
    void 메서드는_0또는_1_무작위_숫자를_가져온다() throws Exception {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int number = bridgeNumberGenerator.generate();
        assertThat(number).isBetween(0, 1);
    }
}