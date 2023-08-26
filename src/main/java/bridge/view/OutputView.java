package bridge.view;

import static bridge.Constants.BridgeConstants.space;

import bridge.BridgeGame;
import bridge.domain.MoveDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    private static final String GAME_RESULT = space + "최종 게임 결과";
    private static final String JUDGE_GAME_SUCCESS = "게임 성공 여부: ";
    private static final String TRY_GAME_COUNT = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String BLANK = " ";
    private static final String SUCCESS_O = "O";
    private static final String FAIL_X = "X";
    private static final String BRIDGE_DELIMITER = " | ";
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        Map<MoveDirection, List<String>> map = generateMap(bridgeGame);
        printRow(map.get(MoveDirection.UP));
        printRow(map.get(MoveDirection.DOWN));
    }

    private void printRow(List<String> row) {
        System.out.println(BRIDGE_START + String.join(BRIDGE_DELIMITER, row) + BRIDGE_END);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCount, BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT);
        printMap(bridgeGame);
        System.out.println(JUDGE_GAME_SUCCESS + checkSuccess(bridgeGame.isSuccess()));
        System.out.println(TRY_GAME_COUNT + tryCount);
    }

    private String checkSuccess(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAIL;
    }

    private Map<MoveDirection, List<String>> generateMap(BridgeGame bridgeGame) {
        int round = bridgeGame.getRound();
        List<String> bridge = bridgeGame.getBridge();
        Map<MoveDirection, List<String>> map = initMap();

        for (int i = 0; i < round - 1; i++) {
            cross(map, MoveDirection.of(bridge.get(i)), true);
        }

        cross(map, MoveDirection.of(bridge.get(round - 1)), bridgeGame.isSuccess());
        return map;
    }

    private Map<MoveDirection, List<String>> initMap() {
        Map<MoveDirection, List<String>> map = new HashMap<>();
        for (MoveDirection direction : MoveDirection.values()) {
            map.put(direction, new ArrayList<>());
        }
        return map;
    }

    private void cross(Map<MoveDirection, List<String>> row, MoveDirection moveDirection,
        boolean isCorrectMoving) {
        MoveDirection otherSide = moveDirection.getOtherSide();
        if (isCorrectMoving) {
            row.get(otherSide).add(BLANK);
            row.get(moveDirection).add(SUCCESS_O);
        } else {
            row.get(otherSide).add(FAIL_X);
            row.get(moveDirection).add(BLANK);
        }
    }
}
