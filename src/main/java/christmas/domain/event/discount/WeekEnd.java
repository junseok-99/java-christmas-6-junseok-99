package christmas.domain.event.discount;

import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.repository.menu.Desert;
import christmas.repository.menu.MainDish;

import java.util.List;

public class WeekEnd implements Discount {

    private static final Integer FRIDAY = 1;
    private static final Integer SATURDAY = 2;

    @Override
    public Boolean isSatisfyCondition(Orders orders) {
        Integer dayOfVisit = orders.getDayOfVisit();
        Integer dayOfTheWeek = dayOfVisit % ONE_WEEK;
        if (FRIDAY <= dayOfTheWeek && dayOfTheWeek <= SATURDAY) {
            return true;
        }
        return false;
    }

    @Override
    public Long discountRate(Orders orders) {
        return WEEK_DISCOUNT_RATE;
    }

    @Override
    public void discount(Orders orders) {
        Boolean discountCondition = isSatisfyCondition(orders);
        if (discountCondition) {
            Long discountPrice = discountMainDish(orders);
            orders.discount(discountPrice);
        }
    }

    private Long discountMainDish(Orders orders) {
        Long totalDiscountPrice = INITIAL_PRICE;
        List<Order> orderList = orders.getOrderList();
        for (Order order : orderList) {
            String menuName = order.menuName();
            Long count = (long) order.count();
            if (MainDish.contains(menuName)) {
                totalDiscountPrice += (count * discountRate(orders));
            }
        }
        return totalDiscountPrice;
    }
}
