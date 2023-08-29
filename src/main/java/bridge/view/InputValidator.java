package bridge.view;

import static bridge.Constants.BridgeConstants.ERROR_MESSAGE;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String INVALID_INPUT_BRIDGE_NUMBER = " 숫자 형식이 아닙니다.";
    private static final String INVALID_BLANK = " 값을 입력하세요.";
    private static final String INVALID_INPUT_BRIDGE_STRING = " 문자 형식이 아닙니다.";
    private static final String INVALID_BRIDGE_SIZE = " 3에서 20사이의 숫자를 입력해주세요.";
    private static final String INVALID_MOVE_DIRECTION = " U와 D중 하나의 값을 입력해주세요.";
    private static final String INVALID_RETRY_COMMAND = " R과 Q중 하나의 값을 입력해주세요.";
    private static final String MOVE_U = "U";
    private static final String MOVE_D = "D";
    private static final String COMMAND_R = "R";
    private static final String COMMAND_Q = "Q";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;


    private InputValidator() {
    }

    public static void validateBridgeSize(String inputBridgeSize) {
        validateBlank(inputBridgeSize);
        Integer number = checkInteger(inputBridgeSize);
        checkInputBridgeSize(number);
    }

    public static void validateBridgeMove(String inputBridgeMove) {
        validateBlank(inputBridgeMove);
        checkString(inputBridgeMove);
        checkInputMove(inputBridgeMove);
    }

    public static void validateBridgeCommand(String inputBridgeRetryCommand) {
        validateBlank(inputBridgeRetryCommand);
        checkString(inputBridgeRetryCommand);
        checkInputRetryCommand(inputBridgeRetryCommand);
    }

    private static Integer checkInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_BRIDGE_NUMBER);
        }
    }

    private static void validateBlank(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_BLANK);
        }
    }

    private static void checkString(String input) {
        if (!Pattern.matches("^[a-zA-Z]*$", input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_BRIDGE_STRING);
        }
    }

    private static void checkInputBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_BRIDGE_SIZE);
        }
    }

    private static void checkInputMove(String move) {
        if (!(move.equals(MOVE_U) || move.equals(MOVE_D))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MOVE_DIRECTION);
        }
    }

    private static void checkInputRetryCommand(String command) {
        if (!(command.equals(COMMAND_R) || command.equals(COMMAND_Q))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_RETRY_COMMAND);
        }
    }
}

