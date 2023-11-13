package christmas.util.validation;

import christmas.repository.MenuRepository;
import christmas.util.OrderIndices;
import christmas.util.SplitTypes;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ValidationOrder {

    private static final Set<String> menuSet = new HashSet<String>();
    private static final Integer FORM_SIZE = 2;
    private static final Integer ZERO = 0;
    private static final Integer MIN_MENU_COUNT = 1;
    private static final Integer MAX_MENU_COUNT = 20;
    private static final String INVALID_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String INVALID_COUNT_SUM_MESSAGE = "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";

    private static Integer countSum = ZERO;

    private ValidationOrder() {

    }

    public static void validateOrder(String ordersString) {
        Stream.of(ordersString.split(SplitTypes.ORDER_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                .map(String::trim)
                .forEach(orderString -> {
                    validateForm(orderString);
                    validateMenuCount(orderString);
                    validateDuplicateMenu(orderString);
                    validateMenuCountSum(orderString);
                    validateMenuInRepository(orderString);
        });
    }

    public static void validateForm(String orderString) {
        Integer menuSize = orderString.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER).length;
        if (menuSize != FORM_SIZE) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public static void validateMenuCount(String orderString) {
        Integer menuCount = getMenuCount(orderString);
        if (menuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public static void validateDuplicateMenu(String orderString) {
        String menuString = getMenu(orderString);
        if (menuSet.contains(menuString)) {
            initReferences();
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
        menuSet.add(menuString);
    }

    public static void validateMenuCountSum(String orderString) {
        countSum += getMenuCount(orderString);
        if (countSum > MAX_MENU_COUNT) {
            initReferences();
            throw new IllegalArgumentException(INVALID_COUNT_SUM_MESSAGE);
        }
    }

    public static void validateMenuInRepository(String orderString) {
        String menuString = getMenu(orderString);
        if (MenuRepository.isMenuInRepository(menuString) == false) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    private static Integer getMenuCount(String orderString) {
        String menuCountString = Stream.of(orderString.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                .toList()
                .get(OrderIndices.COUNT.getIndex());
        return toInteger(menuCountString);
    }

    private static String getMenu(String orderString) {
        return Stream.of(orderString.split(SplitTypes.MENU_REGEX, SplitTypes.REMOVE_SPACE_NUMBER))
                .toList()
                .get(OrderIndices.MENU.getIndex());
    }

    private static Integer toInteger(String menuCountString) {
        try {
            Integer menuCount = Integer.parseInt(menuCountString);
            return menuCount;
        } catch (NumberFormatException notNumericException) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    private static void initReferences() {
        menuSet.clear();
        countSum = ZERO;
    }
}