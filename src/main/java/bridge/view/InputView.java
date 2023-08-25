package bridge.view;

import static bridge.view.InputValidator.validateBridgeMove;
import static bridge.view.InputValidator.validateBridgeSize;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_GAME_START_MESSAGE);
        System.out.println(INPUT_BRIDGE_MESSAGE);
        String inputBridgeSize = Console.readLine();
        validateBridgeSize(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_MESSAGE);
        String inputBridgeMove = Console.readLine();
        validateBridgeMove(inputBridgeMove);
        return inputBridgeMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
