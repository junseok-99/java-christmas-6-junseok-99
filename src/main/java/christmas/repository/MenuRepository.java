package christmas.repository;

import christmas.domain.order.OrderRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {

    private static final Map<String, Long> menuRepository = new HashMap<>();
    private static final Long ZERO = 0L;

    private MenuRepository() {

    }

    public static void initRepository() {
        MenuInitializer.init(menuRepository);
    }

    public static boolean isMenuInRepository(String menuName) {
        return menuRepository.containsKey(menuName);
    }

    public static Long orderedTotalPrice(List<OrderRecord> orderList) {
        Long totalPrice = ZERO;
        for (OrderRecord order : orderList) {
            String menuName = order.menuName();
            Long count = (long) order.count();
            totalPrice += calcOrderPrice(menuName, count);
        }
        return totalPrice;
    }

    private static Long calcOrderPrice(String menuName, Long count) {
        Long price = menuRepository.get(menuName);
        price *= count;
        return price;
    }
}
