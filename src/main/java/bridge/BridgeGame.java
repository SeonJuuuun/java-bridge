package bridge;

import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int tryCount = 1;
    private int round = 0;
    private boolean success = false;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String playerMove) {
        increaseRound();
        String roundByBridge = bridge.get(round - 1);
        boolean result = playerMove.equals(roundByBridge);
        this.success = result;
        return result;
    }

    private void increaseRound() {
        this.round += 1;
    }

    private void increaseTryCount() {
        this.tryCount += 1;
    }

    private void retryGame() {
        this.round = 0;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getTrialCount() {
        return tryCount;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getRound() {
        return round;
    }

    public boolean isSuccess() {
        return success;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        increaseTryCount();
        retryGame();
    }
}
