package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView,
        BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private int initBridgeSize() {
        return inputView.readBridgeSize();
    }
}
