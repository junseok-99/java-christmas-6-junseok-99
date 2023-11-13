package christmas.domain.event.discount;

import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.repository.menu.Desert;

import java.util.List;

public class WeekDay implements Discount {

    private static final Integer SUNDAY = 3;
    private static final Integer WEDNESDAY = 6;
    private static final Integer THURSDAY = 0;
    private static final Long DISCOUNT_RATE = 2_023L;

    @Override
    public Boolean isSatisfyCondition(Orders orders) {
        Integer dayOfVisit = orders.getDayOfVisit();
        Integer dayOfTheWeek = dayOfVisit % ONE_WEEK;
        if (dayOfTheWeek == THURSDAY || (SUNDAY <= dayOfTheWeek && dayOfTheWeek <= WEDNESDAY)) {
            return true;
        }
        return false;
    }

    @Override
    public Long discountRate(Orders orders) {
        return DISCOUNT_RATE;
    }

    @Override
    public void discount(Orders orders) {
        Boolean discountCondition = isSatisfyCondition(orders);
        if (discountCondition) {
            Long discountPrice = discountDesert(orders);
            orders.discount(discountPrice);
        }
    }

    private Long discountDesert(Orders orders) {
        Long totalDiscountPrice = INITIAL_PRICE;
        List<Order> orderList = orders.getOrderList();
        for (Order order : orderList) {
            String menuName = order.menuName();
            Long count = (long) order.count();
            if (Desert.contains(menuName)) {
                totalDiscountPrice += (count * discountRate(orders));
            }
        }
        return totalDiscountPrice;
    }
}
