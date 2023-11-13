package christmas.domain.event.discount;

import christmas.domain.order.Orders;

public class Special implements Discount {

    private static final Integer SUNDAY = 3;
    private static final Integer CHRISTMAS = 25;
    private static final Long SPECIAL_DISCOUNT_RATE = 1_000L;

    @Override
    public Boolean isSatisfyCondition(Orders orders) {
        Integer dayOfVisit = orders.getDayOfVisit();
        Integer dayOfTheWeek = dayOfVisit % ONE_WEEK;
        if (dayOfVisit == CHRISTMAS || SUNDAY == dayOfTheWeek) {
            return true;
        }
        return false;
    }

    @Override
    public Long discountRate(Orders orders) {
        return SPECIAL_DISCOUNT_RATE;
    }

    @Override
    public void discount(Orders orders) {
        Boolean discountCondition = isSatisfyCondition(orders);
        if (discountCondition) {
            Long discountPrice = discountRate(orders);
            orders.discount(discountPrice);
        }
    }
}
