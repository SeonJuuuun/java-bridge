package bridge.view;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INVALID_INPUT_BRIDGE_NUMBER = " 숫자 형식이 아닙니다.";
    private static final String INVALID_BLANK = " 값을 입력하세요.";
    public static final String INVALID_INPUT_BRIDGE_STRING = " 문자 형식이 아닙니다.";

    private InputValidator() {
    }

    public static void validateBridgeSize(String inputBridgeSize) {
        validateBlank(inputBridgeSize);
        Integer number = checkInteger(inputBridgeSize);
    }

    public static void validateBridgeMove(String inputBridgeMove) {
        validateBlank(inputBridgeMove);
        checkString(inputBridgeMove);
    }

    private static Integer checkInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                ERROR_MESSAGE + INVALID_INPUT_BRIDGE_NUMBER);
        }
    }

    private static void validateBlank(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_BLANK);
        }
    }

    private static void checkString(String input) {
        if (!Pattern.matches("^[a-zA-Z]*$", input)) {
            throw new IllegalArgumentException(
                ERROR_MESSAGE + INVALID_INPUT_BRIDGE_STRING);
        }
    }
}

