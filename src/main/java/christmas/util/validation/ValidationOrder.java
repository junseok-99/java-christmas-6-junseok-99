package christmas.util.validation;

import java.util.List;
import java.util.stream.Stream;

public class ValidationOrder {

    private static final Integer FORM_SIZE = 2;
    private static final Integer REMOVE_LAST_SPACE_NUMBER = 0;
    private static final Integer MIN_MENU_COUNT = 1;
    private static final Integer COUNT_INDEX = 1;
    private static final String SPLIT_ORDER_CHARACTER = ",";
    private static final String SPLIT_MENU_CHARACTER = "-";
    private static final String INVALID_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private ValidationOrder() {

    }

    public static void validateOrder(String ordersString) {
        Stream.of(ordersString.split(SPLIT_ORDER_CHARACTER, REMOVE_LAST_SPACE_NUMBER)).forEach(orderString -> {
            validateForm(orderString);
            validateMenuCount(orderString);
        });
    }

    public static void validateForm(String orderString) {
        Integer menuSize = orderString.split(SPLIT_MENU_CHARACTER, REMOVE_LAST_SPACE_NUMBER).length;
        if (menuSize != FORM_SIZE) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public static void validateMenuCount(String orderString) {
        String menuCountString = Stream.of(orderString.split(SPLIT_MENU_CHARACTER, REMOVE_LAST_SPACE_NUMBER))
                .toList()
                .get(COUNT_INDEX);
        Integer menuCount = toInteger(menuCountString);
        if (menuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    private static Integer toInteger(String menuCountString) {
        try {
            Integer menuCount = Integer.parseInt(menuCountString);
            return menuCount;
        } catch (NumberFormatException notNumericException) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }
}