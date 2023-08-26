package bridge.domain;

import static bridge.Constants.BridgeConstants.ERROR_MESSAGE;

import java.util.Arrays;

public enum MoveDirection {

    UP(1, "U"),
    DOWN(0, "D");

    private static final String INVALID_BRIDGE_RANGE_MESSAGE = "0과 1사이의 값을 입력해주세요.";
    private static final String INVALID_MOVE_DIRECTION = "U와 D중 하나의 값을 입력해주세요.";

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
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + INVALID_BRIDGE_RANGE_MESSAGE));
    }

    public static MoveDirection of(String direction) {
        return Arrays.stream(values())
            .filter(v -> direction.equals(v.direction))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + INVALID_MOVE_DIRECTION));
    }

    public MoveDirection getOtherSide() {
        return Arrays.stream(values())
            .filter(direction -> direction != this)
            .findFirst()
            .orElseThrow(IllegalStateException::new);
    }
}
