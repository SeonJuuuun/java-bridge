package bridge.view;

import bridge.BridgeGame;
import bridge.domain.MoveDirection;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    private void printRow(List<String> row) {
        System.out.println("[ " + String.join(" | ", row) + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

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
}
