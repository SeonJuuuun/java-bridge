package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

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

    private List<String> generateBridge() {
        return bridgeMaker.makeBridge(initBridgeSize());
    }

    private String inputPlayerMove() {
        return inputView.readMoving();
    }

    private boolean runGameRound() {
        String move = inputPlayerMove();
        boolean result = bridgeGame.move(move);
        return result;
    }
}
