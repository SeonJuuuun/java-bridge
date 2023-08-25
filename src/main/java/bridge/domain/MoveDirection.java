package bridge.domain;

import java.util.Arrays;

public enum MoveDirection {

    UP(1, "U"),
    DOWN(0, "D");

    private static final String INVALID_BRIDGE_RANGE_MESSAGE = "0과 1사이의 값을 입력해주세요.";

    private final int move;
    private final String direction;

    MoveDirection(int move, String direction) {
        this.move = move;
        this.direction = direction;
    }

    public static String getDirectionFromMove(int move) {
        return Arrays.stream(values())
            .filter(moveDirection -> moveDirection.move == move)
            .findFirst()
            .map(moveDirection -> moveDirection.direction)
            .orElseThrow(() -> new IllegalArgumentException(INVALID_BRIDGE_RANGE_MESSAGE));
    }
}
