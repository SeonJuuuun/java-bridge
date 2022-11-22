package bridge;

public class Controller {
	private final BridgeProgram bridgeProgram = new BridgeProgram();
	private final InputView inputView = new InputView();

	public void run() {
		startBridge();
		setBridge();
		startGame();
		result();
		winFailOrCount();
	}
}
