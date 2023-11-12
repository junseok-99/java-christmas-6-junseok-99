package christmas.util.validation;

import christmas.util.OrderIndices;
import christmas.util.SplitTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ValidationOrder {

    private static final Set<String> menuSet = new HashSet<String>();
    private static final Integer FORM_SIZE = 2;
    private static final Integer MIN_MENU_COUNT = 1;
    private static final String INVALID_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private ValidationOrder() {

    }

    public static void validateOrder(String ordersString) {
        Stream.of(ordersString.split(SplitTypes.ORDER_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                .map(String::trim)
                .forEach(orderString -> {
                    validateForm(orderString);
                    validateMenuCount(orderString);
                    validateDuplicateMenu(orderString);
        });
    }

    public static void validateForm(String orderString) {
        Integer menuSize = orderString.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER).length;
        if (menuSize != FORM_SIZE) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public static void validateMenuCount(String orderString) {
        String menuCountString = Stream.of(orderString.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                .toList()
                .get(OrderIndices.COUNT.getIndex());
        Integer menuCount = toInteger(menuCountString);
        if (menuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public static void validateDuplicateMenu(String orderString) {
        String menuString = Stream.of(orderString.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                .toList()
                .get(OrderIndices.MENU.getIndex());
        if (menuSet.contains(menuString)) {
            menuSet.clear();
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
        menuSet.add(menuString);
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